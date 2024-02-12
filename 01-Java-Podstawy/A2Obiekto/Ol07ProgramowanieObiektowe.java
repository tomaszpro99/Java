package A2Obiekto;

public class Ol07ProgramowanieObiektowe {

    public static void main(String[] args) {

        /*
         * Obiekty - pojemniki na zmienne i funkcje tematycznie ze soba powiazanych do
         * dalszego latwiejszego ponownego uzycia
         * Klasy - feremki do tworzenia egzemplarzy obiektów
         * Properties - wlasciwosci
         * Metody - funkcje
         */

        Monitor abc = new Monitor();
        abc.szerokosc = 123;
        Monitor asd = new Monitor();
        asd.szerokosc = 100;

        System.out.println(abc.szerokosc + ", " + asd.szerokosc);

    }
}

class Monitor {
    int szerokosc;
    int wysyokosc;

    void wlacz() {
        // instrukcje
    }
}