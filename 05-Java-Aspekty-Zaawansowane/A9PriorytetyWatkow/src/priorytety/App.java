package priorytety;

public class App
{
    public static void main(String[] args)
    {
        //Thread.currentThread().setPriority(10); //zmiana prorytetu na 10, czyli najwyzszy 
        System.out.println(Thread.currentThread().getPriority());
        
        Thread watek1 = new Thread(new Thread1(), "maly");
        Thread watek2 = new Thread(new Thread1(), "duzy");
        
        //System.out.println(watek1.getPriority());
        //System.out.println(watek2.getPriority());
        
        watek1.setPriority(Thread.MIN_PRIORITY); //zmiana wartosci
        watek2.setPriority(Thread.MAX_PRIORITY); //"duzy" bedzie wyswietlany czesciej ze wzgledu na wyzszy priorytet
        
        watek1.start();
        watek2.start();
    }
}

class Thread1 implements Runnable
{

    public void run() 
    {
        while(true) //wykonuj sie w nieskonczonosc
          System.out.println(Thread.currentThread().getName());
    }
    
}
class Thread2 implements Runnable
{

    public void run() 
    {
        while(true)
         System.out.println(Thread.currentThread().getName());       
    }
    
}


