package Spinners;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.text.DateFormatSymbols;
//import java.util.Calendar;
//import java.util.Date;

public class App extends JFrame       //SPINNER TO STRZALKI PRZY POLU WYBORU NP DATA
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Spinners");
        this.setBounds(300, 300, 320, 240);

        
        String [] miesiace = new DateFormatSymbols().getMonths(); //getWeekdays(); dni tyg w nazwach: niedziela poniedzialek //pobiera z systemu
        
        // int []tab = new int[3]; //raczej zbedne, moze do miesiecy
        // tab[0] = 1;
        // tab[1] = 2;
        // tab[2] = 42;
     
       /* for (int i = 0; i < miesiace.length; i++) //wypisze miesiace
             System.out.println(miesiace[i]);*/                                             //obetnij
        MySpinnerListModel modelMiesiecy = new MySpinnerListModel(obetnijArray(miesiace,0 , 11)); //spinner 12 miesiecy
        
        JSpinner spinner = new JSpinner(modelMiesiecy); //tworzymy spinner
        SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 30, 1); //spinner liczb 1-30
        
        JSpinner spinner2 = new JSpinner(modelLiczb);
        
        //moj
        SpinnerNumberModel Rok = new SpinnerNumberModel(2000, 1900, 2023, 1); //spinner liczb 1-30
        JSpinner spinner3 = new JSpinner(Rok);

        //Calendar kalendarz = Calendar.getInstance();

        // Date poczatkowaWartosc = kalendarz.getTime();
        // kalendarz.add(Calendar.DAY_OF_MONTH, -20);
        // Date minimalnaWartosc = kalendarz.getTime();
        // kalendarz.add(Calendar.DAY_OF_MONTH, 40);
        // Date maksymalnaWartosc = kalendarz.getTime();
        
        //SpinnerDateModel modelDat = new SpinnerDateModel(poczatkowaWartosc, minimalnaWartosc,maksymalnaWartosc, Calendar.DAY_OF_MONTH);
        //JSpinner spinner3 = new JSpinner(modelDat);
        
        JPanel panel = new JPanel(); //tworzymy panel ze spinnerami
        panel.add(spinner2);
        panel.add(spinner);
        panel.add(spinner3);
        
        this.getContentPane().add(panel, BorderLayout.NORTH); //dodajemy jedyny panel
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class MySpinnerListModel extends SpinnerListModel
    {
        public MySpinnerListModel(Object[] values) //do scrolu miesiecy
        {
            super(values);
            firstValue = values[0];
            lastValue = values[values.length-1];
        }
        @Override
        public Object getNextValue()
        {
            if (super.getNextValue() == null)
                return firstValue;
            else 
              return super.getNextValue();
        }
        @Override
        public Object getPreviousValue()
        {
            if (super.getPreviousValue() == null)
                return lastValue;
            else 
              return super.getPreviousValue();
        }        
        Object firstValue, lastValue;
    }
    /**
     * obcina tablice od <code>poczatek</code> do <code>koniec</code>
     * @param operowany tablica, która będzie operowana
     * @param poczatek indeks od kąd zacząć obcinanie
     * @param koniec indeks gdzie zakończyć obcinanie
     * @return zwraca obcięta tablicę (tmp)
     */
    private Object[] obetnijArray(Object[] operowany, int poczatek, int koniec) { //obcinanie miesiecy

        //zabezpieczenie przed zla wartoscia poczatek/koniec w obetnijArray
//koniec = jezeli koniec jest poza zasiegiem naszej operowanej dlugosci lub jest mniejszy od 0? to zmieniamy go na koncowy : w innym wypadku nic sie nie stanie;
        koniec = koniec > operowany.length -1 || koniec < 0 ? operowany.length-1 : koniec; //czy cos siedzieje? tak: nie;
        poczatek = poczatek < 0 || poczatek > koniec ? 0 : poczatek;
// jezeli poczatek jest mniejszy od zera lub wiekszy od konca? to go wyzerujemy;
        Object[] tmp = new Object[koniec+1-poczatek]; //tworzenie tablicy
        
        for(int i = poczatek, j = 0; i < koniec+1; i++, j++) //obcinamy tablice
            tmp[j] = operowany[i];
            
        return tmp; //zwracamy obcieta tablice
    }
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}


