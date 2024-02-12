package typygeneryczne; //typy uogolnione

import java.util.ArrayList;

public class App
{
    public static void main(String[] args) 
    {
        //ArrayList a = new ArrayList();
        ArrayList<String> a = new ArrayList<String>(); //lista -> kolekcja
      //ArrayList<intiger> a = new ArrayList<intiger>();
        
        a.add(new String("lala1"));
        a.add(new String("lala2"));
        a.add(new String("lala3"));
        a.add(new String("lala4"));
        a.add(new String("lala5"));
        a.add(new String("lala6"));
        
        
        //a.add(new Integer(4)); /
        
        //for (int i = 0; i < a.size(); i++)
        //   System.out.println((String)a.get(i));
        
        for(String stringus : a) //dla kazdego obiektu String z kolekcji a
            System.out.println(stringus);
        
        Zwykla<String> nazwaZmiennej = new Zwykla(); //COKOLWIEK -> string
        nazwaZmiennej.nadajWartosc("cosik");
        System.out.println(nazwaZmiennej.zwroc());
    }
}
class Zwykla <COKOLWIEK> //szablon klasy ktora jest teraz ogolna
{
    public void nadajWartosc(COKOLWIEK wartosc) //string cosik
    {
        this.nazwaZmiennejTypuCokolwiek = wartosc;
    }
    public COKOLWIEK zwroc()
    {
        return this.nazwaZmiennejTypuCokolwiek;
    }
    COKOLWIEK nazwaZmiennejTypuCokolwiek;
}

