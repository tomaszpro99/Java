package A2Obiekto;

public class Ol10StatycznePolaMetody {
    public static void main(String[] args) {

        // Matematyka test = new Matematyka(); //instancja
        // double wynik = test.dodaj(10,20);

        double wynik = Matematyka.dodaj(10, 20); // dzieki static, mozemy wywolac metode bez tworzenia instancji
        System.out.println(wynik);

        System.out.println(Matematyka.PI);

        Klient a = new Klient("Arkadiusz");
        Klient b = new Klient("Wiola");
        Klient c = new Klient("Karol");

        System.out.println(a.id);
        System.out.println(b.id);
        System.out.println(c.id);
    }
}

class Matematyka {
    static final double PI = 3.14;

    static double dodaj(double a, double b) // metoda static - istnieje zawsze
    {
        return a + b;
    }
}

class Klient {
    Klient(String imie) {
        this.imie = imie; // zmienia this.imie na imie ktore zostanie przyslane
        nastepnyID++; // static - stałe - każdy nastepny klient bedzie miał wieksze ID o 1 //liczy sie
                      // kto pierwszy bedzie wywolany

        id = nastepnyID;
    }

    String imie; // this.imie
    int id;
    static int nastepnyID = 0; // wspolne dla wszystkich
}