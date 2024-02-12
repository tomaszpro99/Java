package AbstrakcyjneKlasyStrumieni;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {

        //klasy abstrakcyjne //operuja na bajtach
        InputStream inS;
        OutputStream outS;  //operuja na bajtach

        Reader reader;
        Writer writer; //operuja na bajtach, ale klasy dziedziczace z reader i writer beda mialy odpowiedniki znakowe
        
        Writer writerFile = new FileWriter("A2AbstrakcyjneKlasyStrumieni/A2.txt"); //otwieramy plik
        writerFile.write("tekst"); //korzystamy z metod

        writerFile.close(); //musimy zamknac strumien/potok! aby wszystkie dane zostaly zapisane

        //metoda
        //void nazwaFunkcji(InputStream inS) {}

    }
}
