package StackVectorHashtable;

//stos.jpg - stos, nie mozna wyciagnac elementu bez rozwalania elementow nad nim
// push uklada, pop rozwala


import java.util.*;

public class App
{
    public static void main(String[] args) 
    {
        Stack<String> stos = new Stack<String>();
        
        stos.push("111");
        stos.push("222");
        stos.push("333");
        stos.push("444");
        
        System.out.println(stos.pop()); //sciagnij ze stosu
        System.out.println(stos.pop());
        System.out.println(stos.pop());
        //System.out.println(stos.pop());
        System.out.println(stos);
        
        String nazwa = stos.peek();
        
        if (nazwa.equals("111")) {
            stos.pop();
        } else
            System.out.println("nie ma takiego na samej gorze");
        
        Vector<String> wektor = new Vector<String>(); //Stack - stos, rozszerza takie cos jak wektor
        //vector jest jak Array,LinkedList

        wektor.add("0000");
        wektor.add("1111");
        wektor.add("2222");
          
        System.out.println(wektor.get(2));
    
        //tak naprawde HashMapa pojawila sie od Hashtable, bo rozszerzal kiedys slownik
        HashMap a;
        Hashtable b; //sychro
        //jaka roznica? synchronizacja - wolniejsze dzialanie, jak nie dzialamy na watkach, nie warto kompa meczyc
    }
    
}
