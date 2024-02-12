package A1Wprowadzenie;

public class l01App {

        public static void main(String[] args) throws Exception { // <- psvm

                // Calkowite
                byte i = 127;
                short j = 32767;
                int k = 1000000000; // sout
                long l = 1000000000000000000L;

                // Znakowe
                char a = 'a';
                String imie = "Jan";
                String nazwisko = "Kowalski";
                System.out.println("Imie: " + imie + ", nazwisko: " + nazwisko);

                // Zmienne zmiennoprzecinkowe
                float m = 7.77f;
                double n = 77.7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777;
                final double LICZBA_PI = 3.14; // niezmienna

                // double $salary = 3.21;
                // int #employeeId = 23;
                // System.out.print($salary);

                System.out.println(i + "" + j + "" + k + "" + l + "" + a + "" + m + "" + n + "" + LICZBA_PI); //warning
        }
}
