package PlikiKatalogi;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        
        //File plik = new File("A1PlikiKatalogi/src/PlikiKatalogi/Test.txt"); //dziala ale zrobie z try catch
        // if(!plik.exists()) { //jezli plik nie istnieje
        //     plik.createNewFile(); //stworzymy nowy plik
        // } 
        try
        {
            //File katalog = new File("A1PlikiKatalogi/src/PlikiKatalogi/Katalog"); //tworzymy obiekt katalog
            File katalog = new File("A1PlikiKatalogi/src/PlikiKatalogi/Katalog"+File.separator+"katolog");
            //katalog.mkdir(); //tworzymy katalog //mkdir - make directory - stworz folder
            katalog.mkdirs(); //mkdirs - make directorys

            File plik = new File("A1PlikiKatalogi/src/PlikiKatalogi/Plik.txt"); //tworzymy obiekt plik
            
            if(!plik.exists()) { //jezli plik nie istnieje
                plik.createNewFile(); //stworzymy nowy plik
            }
            System.out.println("Mozliwosc pisania: " + plik.canWrite());  //tylko do odczytu = false, odznaczone = true
            System.out.println("Mozliwosc wywolania: " + plik.canExecute());
            System.out.println("Mozliwosc odczytania: " + plik.canRead());
            System.out.println("Plik ukryty: " + plik.isHidden());
            System.out.println("Typ plik: " + plik.isFile()); //bo mozna tez otwierac katalogi
            System.out.println("Ostatnia modyfikacja: " + new Date(plik.lastModified()));
            System.out.println("Dlugos pliku(ilosc znakow)[bajt]: " + plik.length()); //liczy space

            //plik.delete(); //usuwanie pliku //mozemy usuwac katalogi, ale jezeli cos w nich jest to problem classy itp
            
            //w getProperty mamy stałe do sprawdzania wlasciwosci
            System.out.println("Aktualny katalog: "+System.getProperty("user.dir")); //user.dir =wyswietlenie katalogu na ktorym aktualnie parcujemy
            System.out.println("Nazwa uzytkownika: "+System.getProperty("user.name")); //user.name =nazwa uzytkownika 
            System.out.println("Katalog domowy: "+System.getProperty("user.home")); //user.home =katalog domowy 
            System.out.println("Java Home: "+System.getProperty("java.home")); //java.home

            System.out.println("Sciezka do pliku: "+plik.getPath()); 
            System.out.println("Absolutna sciezka do pliku: "+plik.getAbsolutePath()); 
            System.out.println("Kanoniczna sciezka do pliku: "+plik.getCanonicalPath()); 
            App.wypiszSciezki(new File(System.getProperty("user.dir")));

            plik.list(); //zwraca tablice stringow folderow ze sciezki
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //stworzy piramide sciezek, zaczynajac od glownego folderu projektu
    //metoda statyczna, przyjmujaca nazwe sciezki od ktorej ma zaczac //wypisanie wszystkich plikow i folderow w folderze projektu
    public static void wypiszSciezki(File nazwaSciezki) {
        String[] nazwyPlikowIKatalogow = nazwaSciezki.list(); //Tablica z nazwami Plikow i Katalogow
        System.out.println("===============================================");
        System.out.println("Bazowy folder: "+nazwaSciezki.getPath());

        for (int i = 0; i < nazwyPlikowIKatalogow.length; i++) { //petla przechodzaca przez wszystkie pozycje

            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]); //pobieramy sciezke i dodajemy nazwy plikow, dla wszystikich plikow
            
            //if (p.isFile()) //wypisze TYLKO sciezki dla plikow //mozna tez tylko same foldery
            System.out.println("Plik/katalog w bazowym folderze: "+p.getPath());

            if (p.isDirectory()) //jezeli cos jest folderem
                wypiszSciezki(new File(p.getPath()));
        }

    }
}

