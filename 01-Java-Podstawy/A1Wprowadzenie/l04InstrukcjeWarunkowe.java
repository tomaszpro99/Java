package A1Wprowadzenie;

public class l04InstrukcjeWarunkowe {

    public static void main(String[] args) {

        int WYRAZENIE1 = 1,
                WYRAZENIE2 = 2;

        if (WYRAZENIE1 != WYRAZENIE2)
            System.out.println("rozne");
        else if (WYRAZENIE1 == WYRAZENIE2)
            System.out.println("rowne");
        else
            System.out.println("nie wiem");

        // Switch

        int a = 50; // double, string nie uzywamy w switch
                    // mozna char, wtedy: case 'A':
        switch (a) // przeleci wszystkie instrukcje ktore sa zgodne, zastosowanie break zatrzyma
        {
            case 50:
                System.err.println("a jest równe 50");
                break;
            case 100:
                System.err.println("a jest równe 100");
            default:
                System.err.println("a nie jest równe 50 ani 100, a jest równe " + a);
        }

        // Wyrazenie warunkowe

        int x = 5;

        if (x % 2 == 0)
            System.out.println("parzysta");
        else
            System.out.println("nieparzyta");

        // jezeli tak jest jak nie
        // to samo, ale lepiej: V V
        String czyParzysta = x % 2 == 0 ? "parzysta2" : "nieparzysta2";
        System.out.println(czyParzysta);

    }
}
