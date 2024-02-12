package A1Wprowadzenie;

public class l03Operatory {

        public static void main(String[] args) {

                // Operatory
                // ============================================================================

                int a = 5, c = 1;
                // a += 20; //dodanie wartosci 5+20;
                // a /= 2; //podzielenie przez 2
                a %= 10; // modulo 10 //reszta z dzielenia
                int b = 4 % 3;
                int post = 2; // post++; //POST INKREMENTACJA w nast lini
                int pre = 2; // ++pre; //PRE INKREMENTACJA natychmiast
                System.out.println("Post: " + post++ + ", Pre: " + ++pre); // post 2 pre 3

                // Operator relacyjny (porównania ==)
                // ===================================================

                /*
                 * == czy są równe
                 * != czy sa różne
                 * > wieksze od
                 * >= wieksze, rowne od
                 */

                boolean isTrueFalse = 5 == 4;
                System.out.println(isTrueFalse);

                // Operatory logiczne (true false)
                // =======================================================

                if (a == b)
                        System.out.println("a rowne b");

                // ! - negacja
                // !(true) -> false
                // !(fase) -> true

                if (!(a == b))
                        System.out.println("a rozne od b");

                // && - koniunkcja - "i"
                // TT = True, TF = False, FT = False, FF = False

                // || - "lub"
                // TT = True, TF = True, FT = True, FF = False

                if (a == b && c > 7)
                        System.out.println("a rowne b, i c wieksze od 7");

                if (a == b || c > 7)
                        System.out.println("a rowne b, lub c wieksze od 7");

                // Operatory bitowe (kompresja)
                // =======================================================

                /*
                 * 0 - false 1 - true
                 * 
                 * & - iloczyn bitowy
                 * | - suma bitowa
                 * ~ - negacja bitowa
                 * ^ - XOR
                 * x << 1 - przesuniecie w lewo o 1
                 * x >> 1 - przesuniecie w prawo o 2
                 * 
                 * przykad: 14 & 11 = 10
                 * 
                 * 1 1 1 0 // 14
                 * 1 0 1 1 // 11
                 * ________ 11 = 1, 10 = 0, 11 = 1, 01 = 0
                 * 1 0 1 0 // 10 T F T F
                 * 
                 * alternatywa: 10 || 11 = 11
                 * 
                 * 1 0 1 0 // 10
                 * 1 0 1 1 // 11 VVVVVV
                 * ________ 11 = 1, 10 = 0, 11 = 1, 01 = T
                 * 1 0 1 1 // 11 T F T T
                 * 
                 * xor: 10 ^ 11 = 1
                 * 
                 * 1 0 1 0 // 10
                 * 1 0 1 1 // 11 VVVVVV
                 * ________ 11 = 0, 10 = 0, 11 = 0, 01 = T
                 * 0 0 0 1 // 1 F F F T
                 * 
                 * przesuniecie: 10 >> 1 = 5 (10 o jeden w prawo = 5)
                 * 
                 * 1 0 1 0 // 10
                 * > > > >
                 * 0 1 0 1 // 5
                 * 
                 * negacja: 10~ = -11 (przed ciągiem bitowym jest dodatkowy bit znaku który
                 * negujemy stąd minus)
                 * ?/?
                 * 1/0 1 0 1 0 // 10
                 * 0/1 0 1 0 1 // -11
                 * który nwm
                 * 
                 * 
                 * przyklad uprawnien, 15 zezwoli na 3/4 uprawnien
                 * 0 0 0 1 - dodaj
                 * 0 0 1 0 - edytuj
                 * 0 1 0 0 - usun
                 * 1 0 0 0 - banuj
                 * ________
                 * 1 1 1 0 // 15
                 */

        }
}
