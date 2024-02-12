package F2NadpisywanieMetodPolimorfizm;

public class Potwor { 
    protected double SPEED = 10;  //THIS.SPEED  public- ogolno dostepne, private- niedostepne nawet dla klasy szkielet
    protected double HP = 100;    //THIS.HP     protected - dostepne w klasie dziedziczacej Szkielet, niedostepne w Ol15NadpisywanieMetodPolimorfizm 
//  protected - dostepne gdzie dziedziczenie
    
    protected void atak()
    {
        /* instrukcje ataku */
        System.out.println("Metoda atak, z klasy Potwor");

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
