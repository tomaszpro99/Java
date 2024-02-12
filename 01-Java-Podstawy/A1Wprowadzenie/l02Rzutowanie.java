package A1Wprowadzenie;

public class l02Rzutowanie {

    public static void main(String[] args) {
        int a = 5, b = 12;
        double c = 12, d = 15;

        System.out.println(a / (double) b);

        int wynik1 = (int) d / a;
        double wynik2 = c / d;

        System.out.println((double) 15 / 10);

        System.out.println(wynik1 + wynik2); // skasowanie warninga
    }
}