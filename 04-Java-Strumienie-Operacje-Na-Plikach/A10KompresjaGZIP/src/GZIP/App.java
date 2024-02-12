package GZIP;
//napiszemy klase reprezentujaca towar ktory wyszedl z naszej produkcji

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class App { 
    public static void main(String[] args) {
        
        Towar[] tabTowar = new Towar[4];
        tabTowar[0] = new Towar();
        tabTowar[1] = new Towar(1.01, "Tekst1");
        tabTowar[2] = new Towar(2.02, "Tekst2", 2023, 5, 1);
        tabTowar[3] = new Towar(3.04, "Tekst3", 2022, 12, 13);

        //GZIP TYLKO KOMPRESUJE DANE, ZIP KOMPRESUJE I TWORZY ARCHIWUM
        //GZIP MOZE BYC PRZYDATNY DO SZYBKIEGO WYSLANIA SKOMPRESOWANYCH INSTRUKCJI, ZEBY OBIEKT ZAJMOWAL MNIEJ
        //np. cos przeslac do sieci, im mniej tym lepiej

        try {
                                                                //GZIP
            ObjectOutputStream outS = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("A10KompresjaGZIP/A10.txt")));
            //ObjectOutputStream pozwala serializowac, tworzy obiekty do pliku z kodem seryjnym do identyfikacji

            outS.writeObject(tabTowar); //zapisujemy wszystkie, zeby wczytac wszystkie[]

            outS.close();

            //Output do zapisywania, input do wczytywania
                                                                //GZIP
            ObjectInputStream inS = new ObjectInputStream(new GZIPInputStream(new FileInputStream("A10KompresjaGZIP/A10.txt")));

            Towar[] a = (Towar[])inS.readObject(); //W obiekcie Towar o nazwie a, wczytany obiekt inS zostal zrzutowany na Towar 
            //wczytamy wszystkie[], zrzutujemy wszystkie[]

            for(int i = 0; i < a.length; i++)
                System.out.println(a[i].pobierzNazwe());

            inS.close();

        }
        catch (IOException e) { //nie throws IOException { bo musimy blad obluzyc tutaj
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e) { //zlapiemy wyjatek CNFE z inS.readObject();
            System.out.println(e.getMessage()); //jest to taki wyjatek ze jak (przed)inS.readObject(); zrobimy rzutowanie
        } //i sie pomylimy to otrzymamy ten blad, 
    }
}
