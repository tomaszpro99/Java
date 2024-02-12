package A2Obiekto;

public class Ol12Enkapsulacja {

    public static void main(String[] args) {

        // Enkapsulacja (hermetyzacja) - pakowanie wlasciwosci w taki sposob, aby nie
        // bylo do nich bezposredniego dostepu z innych klas

        KontoBankowe oszczednosciowe = new KontoBankowe();
        // oszczednosciowe.saldo = 100; //brak mozliwosci - prywatne

        oszczednosciowe.setSaldo(1000);
        oszczednosciowe.wyplata(200);
        oszczednosciowe.wplata(400);

        System.out.println(oszczednosciowe.getSaldo());
    }
}

class KontoBankowe {
    public KontoBankowe() {
        saldo = 100;
    }

    private int saldo; // saldo prywatne, nikt z zewnatrz nie zmieni

    int getSaldo() // wyswietl saldo
    {
        return saldo;
    }

    boolean setSaldo(int saldo) {
        /*
         * WARUNKI
         */
        this.saldo = saldo;

        return true;
    }

    boolean wyplata(int ile) {
        if (saldo < ile) // sprawdzenie czy da sie wyplacic
            return false;
        else
            saldo -= ile;
        return true;
    }

    boolean wplata(int ile) {
        setSaldo(saldo + ile);
        return true;
    }
}