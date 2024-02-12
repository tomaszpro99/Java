package newpackage; //Ol11PakunkiModyfikatoryDostepu

public class KlasaTest {
    public static int a = 5; // potrzeba public by skorzystac gdzie indziej

    public static void test() // potrzeba public by skorzystac gdzie indziej z metody
    {
        System.out.println("Wyswieltenie tekstu");
    }

    private static int b = 20;// private - dostepne tylko wewnatrz metody

    void tylkowewnatrzklasy() {
        b = 80;
        System.out.println(b);// usuwam warning
    }

    protected static int c = 30;
}