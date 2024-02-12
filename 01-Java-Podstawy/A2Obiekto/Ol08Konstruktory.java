package A2Obiekto;

public class Ol08Konstruktory {

    public static void main(String[] args) {
        Punkt p = new Punkt(10, 53); // <argumenty
        //Punkt p2 = new Punkt(); // uzywamy konstruktora do stworzenia obiektu p2 z klasy punkt
       
        // p.x = 5;
        // p.y = 20;

        System.out.println("p.x " + p.x);
        System.out.println("p.y " + p.y);

    }
}

class Punkt {
    Punkt() // konstruktor (ta sama nazwa)
    {
        System.out.println("Wywołano konstuktor domyślny");
    }

    Punkt(int zmienna1, int zmienna2) {
        System.out.println("Wywołano konstuktor warunkowy");

        x = zmienna2;
        y = zmienna1;
    }

    int x;
    int y;
}

class Punkt2 // przyklad uzycia this
{
    Punkt2(int x, int y) {
        System.out.println("Wywołano konstuktor warunkowy");
        this.x = x; // Punkt p = new Punkt(10,53); 10 wleci do this.x
        this.y = y; // zmienia this.y na y ktore zostanie przyslane
    }

    int x; // this x
    int y;
}
