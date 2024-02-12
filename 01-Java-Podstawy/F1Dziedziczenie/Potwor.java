package F1Dziedziczenie;

public class Potwor {
    public double SPEED = 10;  //THIS.SPEED
    public double HP = 100;    //THIS.HP

    public void atak() //upublicznic dla Ol14Dziedziczenie
    {
        System.out.println("Metoda atak, z klasy Potwor");

        // w nastepnej lekcji przyklad jak podpisac np metode atak dla niestandardowego ataku lukiem szkieleta
    }

    public Potwor() //konstruktor!
    {
        System.out.println("Domyslny konstruktor, z klasy Potwor");
    }

    public Potwor(double SPEED, double HP)
    {
        this.SPEED = SPEED; //SPEED klasy = SPEED metody
        this.HP = HP;       //this.SPEED to jest "public double SPEED = 10" z klasy, 10 bo tak ustawilismy domyslnie
        System.out.println("Niedomyslny konstruktor, z klasy Potwor");
    }
}
