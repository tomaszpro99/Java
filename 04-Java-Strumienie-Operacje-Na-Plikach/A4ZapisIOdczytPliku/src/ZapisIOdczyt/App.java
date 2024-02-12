package ZapisIOdczyt; 

import java.io.*;

public class App {

    public static void main(String[] args) {
        
        try {
            //klasa, moze drukowac          //true- do pliku bedzie dopisywane a nie od nowa
            PrintWriter drukarz = new PrintWriter(new FileWriter("A4ZapisIOdczytPliku/A4.txt"/*, true*/));
        
            drukarz.println(1234);

            //drukarz.flush(); //wymuszone zapisanie, flush - oproznij (buffor)
            drukarz.close(); //trzeba zamknac bo moze nie wyszystko zostac wyslane z bufforu!!!

            drukarz = new PrintWriter(new FileWriter("A4ZapisIOdczytPliku/A4.txt", true));
            //otwieramy ponownie plik i dopisujemy doniego, true uniemozliwnia tworzenie pliku od nowa
            drukarz.append("asd"); //append - dolacz
            drukarz.println(); //nowa linia
            drukarz.printf("stala: [%d] zmiennoprzecinkowa: [%.3f] string: [%s]",50,50.01,"hej"); //print f - wydrukuj sformatowany tekst //%d digit - liczba
            drukarz.close();                        //.3f - 3miejsca po przecinku
        
        //czytamy z pliku

            BufferedReader reader = new BufferedReader(new FileReader("A4ZapisIOdczytPliku/A4.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("A4ZapisIOdczytPliku/A4przepisane.txt")); //przepisujemy do innego pliku

            
            //System.out.println(reader.read()); //wypisalo 1 znak
            //System.out.println(reader.readLine()); //linie
        
            String tresc = ""; //zeby ogarnal ze string ma byc null
            while((tresc = reader.readLine()) != null) {//jezeli reader jest inny niz null
                
                //System.out.println(tresc);
                writer.write(tresc); //przepisujemy do innego pliku
                writer.newLine();
            }  
            writer.close();
            reader.close();
        
        }
        catch (IOException e) { //obsluga wyjatku
            System.out.println(e.getMessage());
        }
        //App.test(1, 2 , 4, "asd", 3); //args polecialy do tablicy a typu Object -> (Object.. a)


    }
    //metoda statyczna dla statycznego maina
    static void test(Object... a) {

        for (int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);           //wypisanie args
        }
    }
}