package SystemTokenizacji;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar {
    
    //wartosci domyslne
    private double cena;
    private String nazwa;
    private Date dataWydania;

    //publiczny konstruktor domyslny ktory zinicjalizuje te wartosci domyslne
    public Towar() {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
    }
    public Towar(double cena, String nazwa) {
        this(); //wywolujemy konstruktor domyslny
        this.cena = cena;
        this.nazwa = nazwa;
    }
    public Towar(double cena, String nazwa, int y, int m, int d) {
        
        this(cena,nazwa); //wywolujemy konstruktor z args
        GregorianCalendar kalendarz = new GregorianCalendar(y, m-1, d);
        dataWydania = kalendarz.getTime();
    }
    public double pobierzCene() { //double
        return this.cena;
    }
    public String pobierzNazwe() { //string
        return this.nazwa;
    }
    public Date pobierzDate() { //date
        return dataWydania;
    }
    public void ustawCene(double cena) { ///metoda
        this.cena = cena;
    }
    public void ustawNazwedouble(String nazwa) { ///metoda
        this.nazwa = nazwa;
    }
    public void ustawDate(int y, int m, int d) { //metoda
        GregorianCalendar kalendarz = new GregorianCalendar(y, m-1, d);
        dataWydania = kalendarz.getTime();
    }
    public void ustawDate(Date data) { //metoda
        this.dataWydania = data;
    }
    @Override //z Object.java
    public String toString() {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena+" zl; nazwa: "+this.nazwa+" ;"+kalendarz.get(Calendar.DAY_OF_MONTH)+" "+(kalendarz.get(Calendar.MONTH)+1)+" "+kalendarz.get(Calendar.YEAR);
    }
    public static void zapiszDoPliku(Towar[] towar, PrintWriter outS) {

        outS.println(towar.length);
        GregorianCalendar kalendarz = new GregorianCalendar();

        for (int i = 0; i < towar.length; i++) {
            kalendarz.setTime(towar[i].pobierzDate()); //pobieramy date
            outS.println(towar[i].pobierzCene()+"|"+towar[i].pobierzNazwe()+/*towar[i].pobierzDate()+*/"|"+kalendarz.get(Calendar.DAY_OF_MONTH)+"|"+(kalendarz.get(Calendar.MONTH)+1)+"|"+kalendarz.get(Calendar.YEAR));
        }
    }
    public static Towar[] odczytajZPliku(BufferedReader inS) throws IOException {
        
        int dlugosc = Integer.parseInt(inS.readLine()); //parseInt bo nie wie ze to int
        Towar[] temp = new Towar[dlugosc];

        for (int i = 0; i < dlugosc; i++) {

            String linia = inS.readLine(); //wrzucamy linie
            StringTokenizer tokeny = new StringTokenizer(linia, "|"); //przyjmie linie, podajemy token, i dzieli na tokeny miedzy znacznikiem

            double cena = Double.parseDouble(tokeny.nextToken()); //wyciagamy tokeny
            String nazwa = tokeny.nextToken();
            int y = Integer.parseInt(tokeny.nextToken());
            int m = Integer.parseInt(tokeny.nextToken());
            int d = Integer.parseInt(tokeny.nextToken());
            temp[i] = new Towar(cena, nazwa, y, m, d); 
        }
        return temp;
    }
}
