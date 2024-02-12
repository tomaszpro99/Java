import java.util.Scanner;

/*  Implementacja klasy Scanner
 *  Tworzymy obiekt Scanner i uzywamy metod: next() / nextInt() / nextDouble()
 *  do pobrania odpowiedniego typu: String / int / double
 */ 

public class KlasaScanner {
    public static void main(String[] args) {                  
        try (// Tworzymy obiekt klasy Scanner i przypisujemy mu System.in      
        Scanner input = new Scanner(System.in)) {
            // wysyłamy prośbę o podanie imienia użytkownika
            System.out.println("Proszę podać swoje imię : ");
            // pobieramy podaną wartość jako String
            String name = input.next();
            // wypisujemy podane imię użytkownika na ekranie
            System.out.println("Twoje imię to: " + name);
 
            // wysyłamy prośbę o podanie wieku użytkownika
            System.out.println("Proszę podać swój wiek : ");
            // pobieramy podaną wartość jako int
            int age = input.nextInt();
            // wypisujemy podany wiek użytkownika na ekranie
            System.out.println("Twój wiek to: " + age);
 
            // wysyłamy prośbę o podanie pensji użytkownika
            System.out.println("Proszę podać swoją pensję : ");
            // pobieramy podaną wartość jako double
            double salary = input.nextDouble();
            // wypisujemy podaną pensję użytkownika na ekranie
            System.out.println("Twoja pensja to: " + salary);
        }
    }
}
