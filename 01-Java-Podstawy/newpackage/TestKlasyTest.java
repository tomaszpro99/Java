package newpackage; //Ol11PakunkiModyfikatoryDostepu

public class TestKlasyTest { // tylko to moze byc public, tak samo jak nazwa pliku

    public static void main(String[] args) {
        KlasaTest.test(); // klasa Test, metoda test z nowaklasa.java
        // jest to mozliwe poniewaz sa w tym samym pakunku/folderze newpackage
        KlasaTest.a = 20;
    }
}

class Klasa // nie moze byc public, tylko taka jak nazwa pliku
{
    double sa;
}
