package A2Obiekto;

public class Ol24AgregacjaKompozycja {
    
    public static void main(String[] args) {
        Pracownicy50 p = new Pracownicy50("Jan", new Adres("papieza", 2));

        System.out.println(p);
    }

}

class Pracownicy50 {

    String imie;
    Adres adres; //agregacja, klasa adres laczy sie z pracownicy50

    public Pracownicy50(String imie, Adres adres) {
        this.imie = imie;
        this.adres = adres;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.imie + ": " + adres.ulica + " " + adres.nrDomu;
    }
}

class Adres {
    String ulica;
    int nrDomu;

    public Adres(String ulica, int nrDomu) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
    }

}