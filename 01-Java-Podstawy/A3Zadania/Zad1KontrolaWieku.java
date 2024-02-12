package A3Zadania;

public class Zad1KontrolaWieku {

    public static void main(String[] args) throws Exception {

        int wiek = 16;

        if (wiek < 15) {
            System.out.println("Musisz się uczyć.");
        } else if (wiek >= 18 && wiek < 65) {
            System.out.println("Możesz pracować.");
        } else if (wiek >= 65) {
            System.out.println("Możesz iść na emeryturę.");
        } else {
            System.out.println("Nie możesz iść na emeryturę.");
        }

    }
}
