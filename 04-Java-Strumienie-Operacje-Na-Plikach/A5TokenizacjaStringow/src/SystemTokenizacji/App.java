package SystemTokenizacji;
//napiszemy klase reprezentujaca towar ktory wyszedl z naszej produkcji

import java.io.*;

public class App { 
    public static void main(String[] args) {
        
        Towar[] tabTowar = new Towar[3];
        tabTowar[0] = new Towar();
        tabTowar[1] = new Towar(1.01, "1");
        tabTowar[2] = new Towar(2.02, "2", 2023, 5, 1);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("A5TokenizacjaStringow/A5.txt")); //tworzymy plik
            Towar.zapiszDoPliku(tabTowar, writer);
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("A5TokenizacjaStringow/A5.txt")); //otwieramy do czytania
            Towar[] tabTowar3 = Towar.odczytajZPliku(reader); //nowa tablica do czytania
            for(int i = 0; i < tabTowar3.length; i++)
                System.out.println(tabTowar3[i]);
            reader.close();
        }
        catch (IOException e) { //nie throws IOException { bo musimy blad obluzyc tutaj
            System.out.println(e.getMessage());
        }

    }
}
