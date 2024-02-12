package porownywanie;
// CD A8HashSetTreeSet
import java.io.*;
import java.util.*;

class Element implements Comparable //Comparable aby uzywac TreeSet
{
    int wartosc;
    String opis;    
    public Element(int wartosc) //porownywanie po wartosci
    {
        this.wartosc = wartosc;
    }
    public Element(int wartosc, String opis) //porownywanie po opisie String
    {
        this(wartosc);
        this.opis = opis;
    }    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.wartosc == ((Element)obj).wartosc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 14 * hash + this.wartosc;
        return hash;
    }
    public String pobierzOpis() {
        return opis;
    }

    public int compareTo(Object o) //porownywanie obiektow, this obiekt(Element) z pewnym obiektem
    { //zwraca  -1,0,1 mniejszy, wiekszy, rowny
        return wartosc - ((Element)o).wartosc; //rzutowanie do Element
    }
}
public class App 
{
    public static void main(String[] args) 
    {

        Set<Element> set = new TreeSet<Element>( //posegregowane wartosci
            new Comparator<Element>() {//klasa anonimowa Comparator
         //porownywacz przymujacy <Element>

                public int compare(Element o1, Element o2) 
                {
                String opisO1 = o1.pobierzOpis();
                String opisO2 = o2.pobierzOpis();
                
                return opisO1.compareTo(opisO2); //porownanie opisow
                }
            }
        );
  
        set.add(new Element(111, "3222"));
        set.add(new Element(333, "2444"));
        set.add(new Element(555, "1666"));
        
        Iterator<Element> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next().pobierzOpis());
        
        System.out.println("Wielkość zbioru: "+set.size());
    }
}
