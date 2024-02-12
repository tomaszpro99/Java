package wildcards;

import java.util.ArrayList;
import java.util.List;

class SuperClass {   //przyjmuje liste //
    public static void tester(List<? extends Object> lista) {
        /*
         *  ? - wildcard - znak wieloznacznośći
         *  ? extends JakasClassa - znak wieloznacznosci jest ograniczony klasa JakasClassa - bounded wildcard
         */
    }
}
class SubClass extends SuperClass {}

public class App {

    public static void main(String[] args) {

        //1Podkładam za "E" : "String" we wszystkich deklaracjach/definicjach metod 
        List<String> listaStringow = new ArrayList<String>(); //Lista Stringów

        //ArrayList<SubClass> listaClass = new ArrayList<SubClass>();
        List<SuperClass> listaClass = new ArrayList<SuperClass>();
       
        listaClass.add(new SuperClass()); //dodajemy Classy do listyClass, lista superClass
        listaClass.add(new SubClass());

        System.out.println(listaClass.size());
       
        SuperClass.tester(listaStringow); //wysylamy liste do superKlasy
       
        /*
        ArrayList<String> listaS = new ArrayList<String>();
        ArrayList<Object> listaO = listaS; //to jest niemozliwe

        wyjasnienie:
       
        listaO.add(new Integer(4));
        String a = (String) listaO.get(0);
        */
    }
}