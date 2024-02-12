package ZIP;

import java.io.*;
import java.util.zip.*; //rzeczy do zip

public class App {

    public static final int BUFFOR = 1024; //temp

    public static void main(String[] args) throws Exception {
        

        String[] tab = new String[] {"Plik1.txt", "Plik2.txt", "Plik3.txt"};

        byte tempData[] = new byte[BUFFOR]; //miejsce na tymczasowe dane
        try {
            //zapis do pliku zip //1 FileOutputStream otworzenie za pomoca binarnego stylu //2 BufferedOutputStream Szybciej //3 ZipOutputStream okresla strumien typu ZIP // wielkosc
            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("A8ArchiwizacjaDanychZIP/paczka.zip"),BUFFOR));
        
            for (int i = 0; i < tab.length; i++) {

                //musimy najpierw przeczytac dane //BufferedInputStream strumien z ktorego bedziemy mogli czytac dane ktore bedziemy mogli zapisywac, wielkosc
                BufferedInputStream inS = new BufferedInputStream(new FileInputStream("A8ArchiwizacjaDanychZIP/"+tab[i]), BUFFOR);
            
                //wypisujemy nastepny wpis, wrzucamy w kolejke Plik1.txt //ZipEntery przetrzymuje zip
                zOutS.putNextEntry(new ZipEntry(tab[i]));
                //**operacje na Plik1.txt //dopoki nie zamkniemy wpisu Plik1.txt
                
                int counter; //licznik bedzie nam liczyl ile bajtow ma wpisac do nastepnego buffora

                // read: Parameters: 1. b destination buffer. 2. off offset at which to start storing bytes. 3. len maximum number of bytes to read.
                // Returns:     the number of bytes read, or -1 if the end of the stream has been reached.

                //podczas gdy - mozemy przypisac counterowi inS.read(czytajaca wiecej bajtów)(cel czytania, start odkad czytac, ile max czytaj bajtow)
                while ((counter = inS.read(tempData, 0, BUFFOR)) != -1) //dla pliku 1030bajtow: 1raz sie wykona: 1030-1024, drugi raz: counter wyniesie 6 i zwroci -1
                    zOutS.write(tempData, 0, counter); //(dane do zapisania, start zapisywania, ile zapisac bajtow) counter zeby nie zapisywac zawsze 1024
                //counter bedzie liczyl ile bajtow ma wpisac do nastepnego buffora, inS.read wczytujemy za kazdym razem do tempData tymczasowe dane od 0 do wielkosci Buffora 1024 nasze dane z jakiegos pliku, dopoki sa one rozne od -1 czyli dopoki nie jest to koniec strumienia, i bedzie wykonywac nastena linie: ktora bedzie zapisywac tmpData od zera do wielkosci licznika, czyli tyle ile jest bajtow w nastenym bufforze

                zOutS.closeEntry();
                inS.close();
                
            }
            zOutS.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

