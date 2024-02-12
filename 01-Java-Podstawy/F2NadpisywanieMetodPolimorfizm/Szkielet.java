package F2NadpisywanieMetodPolimorfizm;

public class Szkielet extends Potwor{ //extends - odziedzicz klase Potwor
    
    String Weapon; 

    public void atak() //Nadpisana metoda atak z klasy Potwor
    {
        super.atak(); /* instrukcje ataku */ //z klasy Potwór
        /* dodatkowe instrukcje ataku dla szkielet */
        System.out.println("Metoda atak, z klasy Szkielet - nadpisana");

    }
    
    public Szkielet()
    {
        System.out.println("Domyslny konstruktor, z klasy Szkielet");
    }

    public Szkielet(double SPEED, double HP)
    {
        super(SPEED, HP); //chcemy stworzyc obiekt szkielet z niedomylnymi wartosciami,
            //dlatego uzywamy niedomyslnego konstruktora który za pomoca 'super'
        //'super' wywola z klasy wyzej (odziedziczonej(Potwór)) niestandarowy konstruktor i wyslemy mu wartosci 

        //this.SPEED = SPEED; dzieki super, nie potrzebne
        //this.HP = HP;

        System.out.println("Niedomyslny konstruktor, z klasy Szkielet, bez broni");
    }

    public Szkielet(double SPEED, double HP, String Weapon) //to samo ale z bronia
    {
        super(SPEED, HP);
        this.Weapon = Weapon;
        System.out.println("Niedomyslny konstruktor, z klasy Szkielet, z bronia");
    }
}
