package kolejki;

//Program ktory wyszukuje pliki z podanego katalogu, a potem szuka w plikach podanego slowa
//zeby bylo szybciej, zalozymy z gory katalog i szukane slowo

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

import javax.swing.JPopupMenu.Separator;

public class App {
    public static void main(String[] args) {
        
        //kolejka <sciezki>         //implementacja kolejki - ArrayBlockQueue - ile w kolejce
        BlockingQueue<File> kolejkaBlokujaca = new ArrayBlockingQueue<File>(5);
        
        //nowy watek, nowy poszukiwacz(parametry Kolejka, sciezka) start
        new Thread(new PoszukiwaczSciezek(kolejkaBlokujaca, sciezkaGlowna)).start(); //szukamy sciezek
        
        for (int i = 0; i < 50; i++) //przeszukujemy pliki
            new Thread(new PrzeszukiwaczPlikow(kolejkaBlokujaca, slowoSzukane)).start();
    }
    final static private File sciezkaGlowna = new File(System.getProperty("user.dir")+File.separator+"A13Kolejki"); //sciezka
    final static private String slowoSzukane = new String("asd"); //szukane slowo
}

class PoszukiwaczSciezek implements Runnable //poszukiwanie sciezek //Runnable - watek
{
    BlockingQueue<File> kolejka;
    File sciezkaGlowna;
    //przyjmujemy kolejke i sciezke
    public PoszukiwaczSciezek(BlockingQueue<File> kolejka, File sciezkaGlowna) {
        this.kolejka = kolejka;
        this.sciezkaGlowna = sciezkaGlowna;
    }
    public void run() { //Runnable - watek
       try {
           szukajSciezek(sciezkaGlowna); 
           kolejka.put(new File("pusty")); //sygnalizacja konca
       }
       catch(Exception ex) {
           ex.printStackTrace();
       }
    }
    public void szukajSciezek(File sciezka) throws InterruptedException { 
        File[] sciezki = sciezka.listFiles(); //pobiera foldery i pliki
        
        for (int i = 0; i < sciezki.length; i++) 
            if (sciezki[i].isDirectory())  //jezeli znajdzie folder - wchodzi w niego i szuka w nim - rekurencja
                szukajSciezek(sciezki[i]);
            else
                kolejka.put(sciezki[i]); //poloz sciezke do kolejki
    }
}
class PrzeszukiwaczPlikow implements Runnable //przeszukiwanie plikow //Runnable - watek
{
    BlockingQueue<File> kolejka;
    String szukaneSlowo;
    //przyjmujemy kolejke i szukane slowo
    public PrzeszukiwaczPlikow(BlockingQueue<File> kolejka, String szukaneSlowo) {
        this.kolejka = kolejka;
        this.szukaneSlowo = szukaneSlowo;
    }    
    public void run() { //Runnable - watek

       boolean skonczone = false;
       while(!skonczone) { //gdy nie jest skonczone
           try {
               File przeszukiwanyPlik = kolejka.take();
               if (przeszukiwanyPlik.equals(new File("pusty"))) //jezeli nienapotkal tego pliku
               {
                   kolejka.put(przeszukiwanyPlik); //poloz ten pusty do kolejki, info dla innych watkow
                   skonczone = true; //skonczone
               }
               else
                   szukajSlowa(przeszukiwanyPlik); //szukaj slowa
           }
           catch(Exception ex) {
               ex.printStackTrace();
           }
       }
    }
    public void szukajSlowa(File przeszukiwanyPlik) throws FileNotFoundException
    {
        Scanner reader = new Scanner(new BufferedReader(new FileReader(przeszukiwanyPlik))); //scanner
        
        int numerLini = 0; 
        
        while (reader.hasNextLine()) //jak reader ma nastepna linie
        {
            numerLini++; //powieksz int
            
            if (reader.nextLine().contains(szukaneSlowo)) //jezeli nastepna linia posiada szukane slowo, sout
                System.out.println("Szukane słowo znajduje się w pliku: "+przeszukiwanyPlik.getPath()+" w lini "+numerLini);
        }
        reader.close(); //close
    }
}