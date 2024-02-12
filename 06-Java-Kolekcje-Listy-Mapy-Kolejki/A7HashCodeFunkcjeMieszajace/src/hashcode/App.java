package hashcode; //hash - liczba calkowita, kod mieszajacy, hash musi byc rowny dla obu obiektow

class Element { //klasa reprezentujaca element

    public Element(int wartosc) { //element bedzie posiadal poprostu wartosc

        this.wartosc = wartosc;
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true; //sprawdzimy pierw czy this jest rowny obj, przyspieszy sprawdzanie
        if (obj == null || this.getClass() != obj.getClass()) return false;//jezeli obj= null, lub inne klasy
        return this.wartosc == ((Element)obj).wartosc; 
        //return (prawde, jezeli)this wartosc jest rowna wartosci elementu ktory zostanie przyslany 
    }
    @Override
    public int hashCode() { //hashCode - kod mieszajacy

        int hash = 7; //hash to liczba calkowita, mysle ze to klucz
        hash = 14 * hash + this.wartosc; //int
        //double, long, String
        //hash = 89 * hash + (int) (Double.doubleToLongBits(this.cos1) ^ (Double.doubleToLongBits(this.cos1) >>> 32));
        //hash = 89 * hash + (int) (this.cos2 ^ (this.cos2 >>> 32));
        //hash = 89 * hash + (this.cos3 != null ? this.co3.hashCode() : 0);
        return hash;
    }
    int wartosc; //this

    double cos1;
    long cos2;
    String cs3;
}
public class App 
{
    public static void main(String[] args) 
    {
        Element a = new Element(47);
        Element b = new Element(15);
        Element c = null;

        System.out.println(a==b); //false
        System.out.println(a.equals(b)); //false, nie sa rowne bo sa w roznych miejscach w pamieci
        
        System.out.println("asd".hashCode()); //hashCode
        System.out.println("test".hashCode());


        System.out.println(a.hashCode()%128);
        System.out.println(b.hashCode()%128); 
    }
}
