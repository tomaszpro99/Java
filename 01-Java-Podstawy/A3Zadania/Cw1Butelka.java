package A3Zadania;

public class Cw1Butelka {

    private double litry; // private - enkapsulujemy wartosci zeby nie bylo dostepu z zewnatrz

    Cw1Butelka() // trzeba stworzyc domyslny konstruktor, bo tam w petli tworzymy bez wartosci
    {
    }

    Cw1Butelka(double litry) // konstruktor butelka, przyjmujacy double litry
    {
        this.litry = litry;
    }

    double ileLitrow() {
        return litry;
    }

    boolean wlej(double ilosc) {
        double war = ilosc + litry;
        if (war < 3) // jezeli ilosc wlania mniejsza od litrow (pojemnosci) butelk, mozna wylac
            this.litry += ilosc;
        else {
            System.out.println("Przekroczono max 3l");
            return false;
        }
        return true;
    }

    boolean wylej(double ilosc) { // void zmieniony na boolean zeby w przypadku niespelnienia warunku nie
                                  // wykonywac instrukcji w metodzie "przelej"
        if (ilosc < litry) // jezeli ilosc wlania mniejsza od litrow (pojemnosci) butelk, mozna wylac
            this.litry -= ilosc;
        else
            return false;

        return true; // w kazdym innym przypadku zwroc true
    }

    void przelej(double ilosc, Cw1Butelka gdziePrzelac) {
        if (this.wylej(ilosc)) { // wykorzystalismy dwie powyzsze metody, wlej wylej
            gdziePrzelac.wlej(ilosc);
        } else
            System.out.println("Za mało w butelce");
    }

    public static void main(String[] args) {

        Cw1Butelka[] butelka = new Cw1Butelka[50]; // NULL 0-49

        for (int i = 0; i < butelka.length - 2; i++) {
            butelka[i] = new Cw1Butelka();
        }
        butelka[48] = new Cw1Butelka(2);
        butelka[49] = new Cw1Butelka(4);

        butelka[45].wlej(2.5);
        butelka[49].wylej(1.5);

        butelka[48].przelej(0.4, butelka[46]);

        for (int j = 0; j < butelka.length; j++) {
            System.out.println("Butelka " + j + " " + butelka[j].ileLitrow());
        }
    }

}
