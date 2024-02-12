package A2Obiekto;

public class Ol19KlasaObiectPorownywanieObiektow {

    public static void main(String[] args) {
        
        Object p3 = new Punkt0(55,44);
        System.out.println(p3);
        //zrobimy rzutowanie zeby Object p3 mial tez dostep do metod z klasy Punkt0
        
        Punkt0 p = new Punkt0(4, 10); //adres
        Punkt0 p2 = new Punkt0(4, 10); //adres

        //System.out.println(p.getClass());

        if (p == p2)        //porownywanie adresow
            System.out.println("== sa rowne");

        if (p.equals(p2))       //dzieki metodznie nie porownujemy juz adresow, a rzeczy w tych adresach czyli obiekty
            System.out.println("equals sa rowne");
    }
}

class Punkt0 extends Object // tak jest domyslnie, ze kazda klasa rozszerza klase Object (super klase)
{
    private int x;
    private int y;

    Punkt0() {
    }

    Punkt0(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override //adnotacja ze to cos bedzie nadpisywane
    public boolean equals(Object obj) {

        if (this == obj) // jezeli aktualny wysylany obj jest rowny teamu co zostanie przystlany zwroc prawde, zeby nie porownywac p == p
            return true;
        if (obj == null) //spawdz przed czy obj nie jest rowny null zeby nie dalo bledu
            return false;
        // czy aktualna klasa jest rozna od tego co zostalo przyslane w obj
        if (this.getClass() != obj.getClass()) //porownujemy czy mamy klase powiazana z obiektem
            return false; //bylby przypal jakbysmy chcieli porownac np punkt z punkt3D, no cos czego nie mozna porownywac

        Punkt0 przyslany = (Punkt0)obj;             //porownujemy przyslane punktu

        return this.x == przyslany.x && this.y == przyslany.y; 
    }

}