package A1Wprowadzenie;

public class l05Tablice {

    public static void main(String[] args) {

        // tablica jednowymiarowa [a,b,c]

        // deklaracja= inicjalizacja
        int[] tab = new int[5];
        // ^ rezerwujemy int na 5 miejsc

        tab[0] = 20;
        tab[1] = 20;
        tab[2] = 20;
        tab[3] = 20;
        tab[4] = 20;

        System.out.println(tab[0]);

        int[] tab2 = { 4, 14, 4, 444 };
        System.out.println(tab2.length); // dlugosc tablicy
        System.out.println(tab2[tab2.length - 1]); // ostatni element tablicy

        // tablica wielowymiarowa [kolumny, wiersze]
        // 00 01 02 03<- indexy
        // 10 11 12 13
        // 20 21 22 23<- 25

        int[][] tab3 = new int[3][4];
        tab3[2][3] = 25;
        System.out.println(tab3[2][3]);

        int[][] tab4 = {
                { 43, 52, 54, 82 },
                { 23, 78, -45, 8 },
                { 78, 35, 26, 58 }
        };
        System.out.println(tab4[1][2]);
    }
}
