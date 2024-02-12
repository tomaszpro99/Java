package A2Obiekto;

public class Ol13ZmienneReferencyjne3 {

    public static void main(String[] args) {

        String name = "Arkadiusz";
        String name2 = "Arkadiusz";

        if (name == name2) // naprawde porownywane sa adresy, java takie same stringi trzyma w tym samym
                           // miejscu
            System.out.println("są równe");

        String name3 = new String("Arkadiusz");
        String name4 = new String("Arkadiusz");

        if (name3 == name4) // nie rob optymalizacji, stworzy dwa zupelnie osobne adresy
            System.out.println("są równe"); // niepowodzenie

        String name5 = new String("Arkadiusz");
        String name6 = new String("Arkadiusz");

        if (name5.equals(name6)) // porównaj rzeczywiscie stringi, porównaj znaki
            System.out.println("są równe");

    } // STRING JEST WYJATKOWY W PRZYPADKU REFERENCJI, UZYWAJMY EQUALS
}
