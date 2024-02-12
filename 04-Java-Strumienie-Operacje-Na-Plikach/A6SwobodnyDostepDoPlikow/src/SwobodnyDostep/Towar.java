package SwobodnyDostep;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import java.util.StringTokenizer;


public class Towar 
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
    @Override //z Object.java
    public String toString()
    {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zł; nazwa: "+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+(kalendarz.get(Calendar.MONTH)+1)+" m "+kalendarz.get(Calendar.DAY_OF_MONTH)+" dz ";
    }
    
    public static void zapiszDoPliku(Towar[] towar, DataOutput outS) throws IOException
    {
        for (int i = 0; i < towar.length; i++)
          towar[i].zapiszDane(outS);
    }
    public static Towar[] odczytajZPliku(RandomAccessFile RAF) throws IOException 
    {
        int ilRekordow = (int) (RAF.length()/Towar.DLUGOSC_REKORDU); // 240/80 = 3 rekordy
        Towar[] towar = new Towar[ilRekordow]; //tablica o dl 3
        
        for (int i = 0; i < ilRekordow; i++) //3 razy

        {
            towar[i] = new Towar(); //zmieni wartosc wskazywana z null na inna
            towar[i].czytajDane(RAF); //dane zostana przeczytane w czytajDane
        }
        
        return towar;
    }
    public void zapiszDane(DataOutput outS) throws IOException { //ta metoda moze przyjac accesRandomFile, i moze ja oblugiwac
        //metoda do zapisu pojedynczego
        outS.writeDouble(this.cena);
        
        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY); //buffor ze stringiem
        stringB.append(this.nazwa);
        stringB.setLength(Towar.DLUGOSC_NAZWY); //nazwa zawsze bedzie takiej samej dlugosci, przypisuje kazdej wart nadmiar znak 0
        outS.writeChars(stringB.toString());
        
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        
        outS.writeInt(kalendarz.get(Calendar.YEAR));
        outS.writeInt((kalendarz.get(Calendar.MONTH)+1));
        outS.writeInt(kalendarz.get(Calendar.DAY_OF_MONTH));
    }
    public void czytajDane(DataInput inS) throws IOException
    {
        this.cena = inS.readDouble(); //czytaj doubla
        
        StringBuffer tString = new StringBuffer(Towar.DLUGOSC_NAZWY);
        
        for (int i = 0; i < Towar.DLUGOSC_NAZWY; i++) //wykona sie 30 razy, jezeli char jest inny niz null, to dodaj append
        {
            char tCh = inS.readChar();
            
            if (tCh != '\0')
                tString.append(tCh);
        }
       
        this.nazwa = tString.toString();
        
        int rok = inS.readInt();
        int m = inS.readInt();
        int dz = inS.readInt();
        
        GregorianCalendar kalendarz = new GregorianCalendar(rok,m-1,dz);
        this.dataWydania = kalendarz.getTime();
    }     
    public void czytajRekord(RandomAccessFile RAF, int n) throws IOException, BrakRekordu
    {
        if (n <= RAF.length()/ Towar.DLUGOSC_REKORDU)
        {
            RAF.seek((n-1)*Towar.DLUGOSC_REKORDU);
             this.czytajDane(RAF);
        }
        else
            throw new BrakRekordu("Niestety nie ma takiego rekordu");
    }
       
    public static final int DLUGOSC_NAZWY = 30;
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;
    //wartosci domyslne
    private double cena; //8 bajtow
    private String nazwa; //DLUGOSC_NAZWY * 2 bajtów
    private Date dataWydania; //4 bajty + 4 + 4 = 12 bajtow RAZEM 80
    //razem 80bajtow //potrzebujemy tego do przewijania rekordow
}
