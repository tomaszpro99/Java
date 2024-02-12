package hashsettreeset;
// CD A7HashCodeFunkcjeMieszajace
import java.io.*;
import java.util.*;

class Element
{
    public Element(int wartosc)
    {
        this.wartosc = wartosc;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.wartosc == ((Element)obj).wartosc;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 14 * hash + this.wartosc;
        return hash;
    }
    int wartosc;
}
public class App
{
    public static void main(String[] args) 
    {
        long mili = 0;
        long totalMili = 0;
        Set<String> set = new HashSet<String>(512); //Set-zbior, przyjmujacy string, nieuporzadkowane, nie robiace duplikatow(2 te same slowa)
        //set = new TreeSet<String>(); //uporzadkuje slowa wg alfabetu
        try
        {
            Scanner reader = new Scanner(new BufferedReader(new FileReader("A8HashSetTreeSet/informatyka.txt"))); //klasa scaner do czytania pliku
            
            while(reader.hasNext()) //gdy iterator readera ma nastepne slowo
            {
                mili = System.currentTimeMillis(); //pobierz czas

                set.add(reader.next());

                totalMili+= (System.currentTimeMillis() - mili); //sumuj czas
            }
            reader.close(); //!
        }
        catch (Exception ex) //scaner error
        {
            ex.printStackTrace();
        }
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        
        System.out.println("Czas wykonania: "+totalMili+" ms"); //zsumowany czas
        System.out.println("Wielkość zbioru: "+set.size()); //wielkosc zbioru
    }
}
