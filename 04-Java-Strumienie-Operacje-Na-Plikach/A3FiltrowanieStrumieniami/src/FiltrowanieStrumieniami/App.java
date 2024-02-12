package FiltrowanieStrumieniami;

import java.io.*;

public class App {  //strumienie mozna miedzy soba laczyc czyli filtowac, laczymy konstruktor z drugim konstruktorem
    public static void main(String[] args) throws IOException { //WARTO UZYCWA BufferedWriter, ma metode .newLine();

        //klasy abstrakcyjne //operuja na bajtach
        InputStream inS;
        OutputStream outS;  //operuja na bajtach

        Reader reader;
        Writer writer; //operuja na bajtach, ale klasy dziedziczace z reader i writer beda mialy odpowiedniki znakowe
        
        File plik = new File("A3FiltrowanieStrumieniami/A3.txt");

        //sflitrowanie strumieni: FileWriter - pozwala otworzyc plik, BufferedWriter - Buffer - Rozni sie tym ze pliki sa dodatkowo bufforowane, 
        //poczatkowo przetrzymywane w bufforze, dopiero przy zamknieciu wysylane sa jako jeden pakunek, przyspieszeanie dzialania programu
        //BufferedWriter writerFile = new BufferedWriter(new FileWriter(plik));

        //sflirowalismy, poznawa nam znalezc sciezke, FileOutputStream - otwiera strumien, OutputStreamWriter- pozawala zapisac, BufferedWriter - pozwala zapisywac cos do pliku i bufforuje i przyspiesza
        BufferedWriter writerFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(plik)));

        writerFile.write("pierwsza linijka");
        //dzieki klasie abstrakcyjnej BufferedWriter, mozemy uzyc:
        writerFile.newLine();
        //Mozemy tez stworzyc Object writerFile wtedy trzeba rzutowac: ((BufferedWriter)writerFile).newLine();
        writerFile.write("druga linijka");

        writerFile.close(); //musimy zamknac strumien/potok! aby wszystkie dane zostaly zapisane

        //metoda
        //void nazwaFunkcji(InputStream inS) {}

    }
}