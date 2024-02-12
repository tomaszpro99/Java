package A2Obiekto;

public class Ol13ZmienneReferencyjne {

    public static void main(String[] args) {

        Test2 x = new Test2(); // w x nie znajduje się żadna wartość zwykła typowa prymitywna TYLKO ADRES
        System.out.println("x.i: " + x.i + " y.i: X" + " z.i: X");
        Test2 y = x;
        System.out.println("x.i: " + x.i + " y.i: " + y.i + " z.i: X");
        Test2 z = new Test2();
        y.i = 40;
        z.i = 30;
        System.out.println("x.i: " + x.i + " y.i: " + y.i + " z.i: " + z.i);

        String imie = "Arkadiusz";
        String imie2 = imie;
        // String imie2 = new String(imie) // to samo
        imie2 = "Adam";

        System.out.println(imie + " " + imie2);
    }
}

class Test2 {
    int i;
}

/*
 * public class Ol132ZmienneReferencjne {
 * 
 * public static void main(String[] args) {
 * 
 * int a = 5;
 * 
 * Test4 x = new Test4();
 * 
 * x.zmienWartosc(a);
 * 
 * System.out.println(a);
 * }
 * }
 * 
 * class Test4 {
 * void zmienWartosc(int zm) {
 * zm = zm + 2;
 * }
 * }
 */
