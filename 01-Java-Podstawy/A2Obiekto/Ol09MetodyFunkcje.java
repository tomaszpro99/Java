package A2Obiekto;

public class Ol09MetodyFunkcje {

    public static void main(String[] args) {
        // System.out.println(); println to funkcja wypisania na ekran

        Test a = new Test();
        a.wypisz("blabla", "blublu");

        Test a2 = new Test();
        a2.wypisz("XD", "XDDD");

        int wynik = a.dodaj(10, 20);
        System.out.println(wynik);

        double wynik2 = a.dodaj(4.15, 42.42); // do PRZECIAZENIE METODY dodaj

        System.out.println(wynik2);
    }
}

class Test { // parametry
    void wypisz(String argument1, String argument2) // typ metody void, nazwa metody "wypisz" void nic nie zwraca,
                                                    // wykonuje
    {
        System.out.println(argument1 + " " + argument2);
    }

    int dodaj(int a, int b) // musi cos zwrocic
    {
        return a + b;
    }

    double dodaj(double a, double b) // PRZECIAZENIE METODY dodaj
    {
        return a + b;
    }

    double dzielenie(double a, double b) {
        if (b == 0)
            return 0; // return zwraca i zatrzymuje metode

        return a / b;
    }
}