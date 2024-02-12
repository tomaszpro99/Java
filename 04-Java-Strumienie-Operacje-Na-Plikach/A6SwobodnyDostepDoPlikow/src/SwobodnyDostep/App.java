package SwobodnyDostep;
//napiszemy klase reprezentujaca towar ktory wyszedl z naszej produkcji

import java.io.*;

public class App { 
    public static void main(String[] args) {
        
        Towar[] tabTowar = new Towar[4];
        tabTowar[0] = new Towar();
        tabTowar[1] = new Towar(1.01, "Tekst1");
        tabTowar[2] = new Towar(2.02, "Tekst2", 2023, 5, 1);
        tabTowar[3] = new Towar(3.04, "Tekst3", 2022, 12, 13);

        try {
            //Dane Bianarne
            // DataOutputStream outS = new DataOutputStream(new FileOutputStream("A6SwobodnyDostepDoPlikow/A6.txt"));
            // outS.writeDouble(21.37);
            // outS.close();

            // DataInputStream inS = new DataInputStream(new FileInputStream("A6SwobodnyDostepDoPlikow/A6.txt"));
            // System.out.println(inS.readDouble());
            // inS.close();

        //SwobodnyDostepPlik SDP
            RandomAccessFile RAF = new RandomAccessFile("A6SwobodnyDostepDoPlikow/A6.txt", "rw"); //r w rw

            //RAF.writeDouble(4.22);
            //RAF.writeDouble(1.11);
            //RAF.writeChars("asdasd");

            // System.out.println(RAF.getFilePointer());  //ilosc znakow w bajtach

            // RAF.seek(0);
            // System.out.println(RAF.readDouble());
            // RAF.seek(8); //8bajtow dalej
            // System.out.println(RAF.readDouble());

            // System.out.println(Double.SIZE/8);

            Towar.zapiszDoPliku(tabTowar, RAF);
            RAF.seek(0);
            Towar[] towary = Towar.odczytajZPliku(RAF);

            for (int i = 0; i < towary.length; i++) {
                System.out.println(towary[i].pobierzCene());
                System.out.println(towary[i].pobierzNazwe());
                System.out.println(towary[i].pobierzDate());
                System.out.println("==============================");
            }

            /* int n = 2;
           RAF.seek((n-1)*Towar.DLUGOSC_REKORDU);
           
           Towar a = new Towar();
           a.czytajDane(RAF);
           
           System.out.println(a);
           */
           try
           {
               Towar b = new Towar();

               b.czytajRekord(RAF, 3);
               //System.out.println(b);

               //System.out.println("asd");
           }
           catch(BrakRekordu err)
           {
               System.out.println(err.getMessage());
           }
           RAF.close();
        }
        catch (IOException e) { //nie throws IOException { bo musimy blad obluzyc tutaj
            System.out.println(e.getMessage());
        }

    }
}
