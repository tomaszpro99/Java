package SerializacjaObiektow;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.StringTokenizer;


public class Towar implements Serializable //jak cos narazonoe sa dane przy Serializacji, dodajmy haslo
{
    public Towar() //publiczny konstruktor domyslny ktory zinicjalizuje te wartosci domyslne
    {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
    }
    public Towar(double cena, String nazwa)
    {
        this(); //wywolujemy konstruktor domyslny
        this.cena = cena;
        this.nazwa = nazwa;
    }
    public Towar(double cena, String nazwa, int rok, int m, int dz)
    {
        this(cena, nazwa); //wywolujemy konstruktor z args
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    public double pobierzCene()
    {
        return this.cena;
    }
    public String pobierzNazwe()
    {
        return this.nazwa;
    }
    public Date pobierzDate()
    {
        return dataWydania;
    }
    public void ustawCene(double cena)
    {
        this.cena = cena;
    }
    public void ustawNazwe(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public void ustawDate(int r, int m, int dz)
    {
        GregorianCalendar kalendarz = new GregorianCalendar(r, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    public void ustawDate(Date data)
    {
        this.dataWydania = data;
    }
    public String pobierzHaslo()
    {
        return this.haslo;
    }
    @Override //z Object.java
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zł; nazwa: "+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+(kalendarz.get(Calendar.MONTH)+1)+" m "+kalendarz.get(Calendar.DAY_OF_MONTH)+" dz ";
    }

    private void readObject(ObjectInputStream inS) throws IOException,ClassNotFoundException { //do czytania
        inS.defaultReadObject();
        if (haslo != null)
            if (!haslo.equals("admin"))
                throw new IOException("Dane sa nieprawidlowe");
        //System.out.println("Ja teraz wywoluje sie z metody readObject");
    }
    private void writeObject(ObjectOutputStream outS) throws IOException { //do zapisywania
        outS.defaultWriteObject();
    
    }

    //wartosci domyslne
    private double cena;
    private String nazwa; 
    private Date dataWydania;


    private transient String haslo = "admin"; //transient - ulotny, dana ulotna ktora nie zostanie zserializowana
    //takie delikatne dane powinny byc oznaczone transient, lub zupelnie nie implementowac serializacji!  
}
