package A2Obiekto;

public class Ol22KlasyZagniezdzoneWewnetrzne
{

    public static void main(String[] args) 
    {
        A zewnetrzna = new A(); //zwykla klasa - zewnetrzna
        
        A.B tmp = zewnetrzna.new B(); //zagniezdzona
       
        A.C tmp2 = new A.C(); //statyczna moze istniec bez zewnetrznej!

        System.out.println(tmp + "" + tmp2); //warning
        
    }
    
}

class A {
    A() {
        System.out.println("Jestem z klasy zewnętrznej A");
    }
    
    class B { //zagniezdzona
        B() {
            System.out.println("Jestem z klasy zagnieżdzonej B");
        }

        void cosB() {
            a = 5; //dziala 
            cosA();
            
        }

        private int b;
                                                int B = b; //warning
    }

    void cosA() {
         //b = 5; //nie dziala
         //cosB();

         B obj = new B();
         obj.b = 3; //tak juz dziala
    }
    private int a;                  
                                                int A = a; //warning
      
    //zagniezdzona statyczna
    static class C { //statyczna moze istniec bez zewnetrznej! nie ma dostepu do zewnetrznej, do np int a;
        C() {
            System.out.println("Jestem z klasy zagnieżdzonej C");
            //a = 3; blad
        }
    }

    void cosC()
    {
      //  tmp = 2;
        B obj = new B();
                                                System.out.println(obj); //warning
    }
  
}