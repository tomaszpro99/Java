package A3Zadania;

public class Zad2SumaWartosci {

    public static void main(String[] args) {
        int[] liczby = { 1, 12, 41, 12, 51, 12 };

        int suma = 0; // zad: zsumuj tablice

        for (int i = 0; i < liczby.length; i++) {
            System.out.print(suma + " + " + liczby[i]);
            suma += liczby[i];
            System.out.println(" = " + suma);
        }

        // nieskonczona petla
        int i = 0;
        for (; i < 5;) {
            System.out.println("test");
        }

    }
}
