package A2Obiekto;

public class Ol17Instanceof {

    public static void main(String[] args) {
        
        Osoba[] osoba = new Osoba[4];
        osoba[0] = new Pracownik("Adam","Adamowicz", 2000);
        osoba[1] = new Student("Jan", "Janowski");

        for (int i=0; i < osoba.length; i++)
        {
            if (osoba[i] instanceof Osoba)  // jeżeli (osoba[i] jest instancja(egzemplarzem) klasy Osoba)  
                osoba[i].pobierzOpis();     // zabezpiecza przed bledem drukowania nieistniejacych instancji osoba[2,3]
            else
                break;
        }
        // ERROR:
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "A2Obiekto.Osoba.pobierzOpis()" because "osoba[i]" is null
        // at A2Obiekto.Ol17Instanceof.main(Ol17Instanceof.java:13)

        for (Osoba person: osoba) //to samo, ulepszona petla
        {
            if (person instanceof Osoba)
                person.pobierzOpis();
            else
                break;
        }
    }   
}

abstract class Osoba{
    String imie;
    String nazwisko;

    Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    abstract void pobierzOpis(); //opis bedzie wymagany
}

class Pracownik extends Osoba{
    double wynagrodzenie;
    Pracownik(String imie, String nazwisko, double wynagrodzenie) {
        super(imie, nazwisko);
        this.wynagrodzenie = wynagrodzenie;
    }
    void pobierzOpis()
    {System.out.println("Opis pracownik");}
}

class Student extends Osoba{
    Student(String imie, String nazwisko) {
        super(imie, nazwisko);
    }
    void pobierzOpis()
    {System.out.println("Opis student");}
}