package A2Obiekto;

public class Ol13ZmienneReferencyjne2 {

    public static void main(String[] args) {

        int a = 5;

        Test3 x = new Test3(); // tworzenie obiektu
        a = x.zwroc(a); // a = wywolujac metode 'zwroc' przesle do obiektu x, a
        System.out.println(a); // a=7, obiekt x nie ma wartosci, tylko ADRES

        Klasa3 obiekt = new Klasa3(); // rezerwujemy miejsce w pamieci, ADRES
        x.podmien(obiekt);
        System.out.println(obiekt);
    }
}

class Test3 {
    int zwroc(int zm) // void na ina zmieniony zeby zwracal, otwrzymuje (int zm)
    {
        zm = zm + 2;
        return zm; // zwroc do x, x do a
    }

    void podmien(Klasa3 zm) { // mic nie zwraca, a podmienia
        zm.y = zm.y + 40;
    }
}

class Klasa3 {
    int y = 20;
}