package A2Obiekto;

public class Ol18RzutownieWDolLateBinding {

    public static void main(String[] args) {
        
        Osoba8[] osoba = new Osoba8[4];
        osoba[0] = new Pracownik8("Adam","Adamowicz", 2000);
        osoba[1] = new Student8("Jan", "Janowski");
        osoba[2] = new Pracownik8("Adam2","Adamowicz2", 30000);
        osoba[3] = new Pracownik8("Adam3","Adamowicz3", 1111);

        for (Osoba8 person: osoba) //to samo, ulepszona petla
        {
            if (person instanceof Pracownik8)
            {
               ((Pracownik8)person).work(); //rzutowanie w dol na pracownika //potraktowalismy person jako Pracownik
            }
            else if (person instanceof Student8)
            {
               Student8 tmp = (Student8)person; //to samo, co w pracownik ale rozpisane
               tmp.pobierzOpis();
            }                         
        }       
    }   
}

abstract class Osoba8{
    String imie;
    String nazwisko;

    Osoba8(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    abstract void pobierzOpis(); //opis bedzie wymagany
}

class Pracownik8 extends Osoba8{  //pracownik rozszerza Osobe, jest niżej (w dol)
    double wynagrodzenie;
    Pracownik8(String imie, String nazwisko, double wynagrodzenie) {
        super(imie, nazwisko);
        this.wynagrodzenie = wynagrodzenie;
    }
    void pobierzOpis(){
        System.out.println("Opis pracownik");}

    void work(){ //motoda do rzutowania w dol, nie ma absstrakcyjnej jak pobierzOpis
        System.out.println("Pracownik pracuje");
    }
}

class Student8 extends Osoba8{
    Student8(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    void pobierzOpis()
    {System.out.println("Opis student");}
}