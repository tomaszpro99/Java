package A1Wprowadzenie;

public class l06Petle {

    public static void main(String[] args) {

        // petla while, do
        String[] tablica = { "start", "a", "b", "c", "d", "e", "stop" };

        int i = 0;
        while (i < tablica.length) // pierw warunek
        {
            // if ( i != 3)
            {
                System.out.println("while: " + tablica[i]);
            }
            i++;
        }
        ;

        int j = 0;
        do // chociaz raz sie wykona, potem warunek
        {
            // if ( j != 3)
            {
                System.out.println("do: " + tablica[j]);
            }
            j++;
        } while (j < tablica.length);

        // petla for

        for (int k = 0; k < tablica.length; k++) // (inicjalizacja zmiennych, warunek petli, co ma sie stac po wykonaniu
                                                 // wszystkich instrukcji w petli)
        {
            {
                System.out.println("for: " + tablica[k]);
            }
        }
        ;

        // petla enhanced for

        for (String pojemnik : tablica) {
            {
                System.out.println("e-for: " + pojemnik);
            }
        }
        ;

        // petla w petli

        for (int b = 1; b <= 10; b++) // tabliczka mnozenia
        {
            for (int a = 0; a <= 10; a++) {
                System.out.print(a * b + " ");
            }
            System.out.println();
        }

        for (int d = 1; d <= 10; d++) // wycentrowana w konsoli tabliczka mnozenia
        {
            for (int c = 0; c <= 10; c++) {
                int e = 0;
                e = c * d;
                if (e >= 10)
                    System.out.print(c * d + " ");
                if (e < 10)
                    System.out.print("0" + c * d + " ");
            }
            System.out.println();
        }

        // break continue

        for (int x = 0; x < 10; x++) {
            if (x == 3)
                continue; // nie wykonuj, ale kontynuj dalej petle
            if (x == 5)
                break; // zatrzymaj petle
            System.out.println(x);
        }

    }
}
