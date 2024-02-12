package Listy;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class App extends JFrame
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Lista");
        this.setBounds(300, 300, 320, 240);
        //String [] nazwa = new String[] {"lala", "hmm"};
        
        listaPrzedmiotow.setVisibleRowCount(5); //dlugosc listy 
        //listaPrzedmiotow.setFixedCellHeight(40); //wys pozycji w liscie
        //listaPrzedmiotow.setFixedCellWidth(70); //szer pozycji w liscie
        listaPrzedmiotow.setSelectionBackground(Color.RED); //kolor wybranej pozycji w liscie
        listaPrzedmiotow.setSelectionForeground(Color.WHITE); //kolor wybranej czcionki pozycji w liscie
        
        //listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP); //zawijanie listy poziome
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //ustawiamy Mode - styl zaznaczenia
                            //Multiple - mozna kilka zaznaczyc //single - jedno //single2- kilka ale po koleji
        
        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) 
            {
                System.out.println("Zmieniłem się "+(++i)); //licznik wybierania, przytrzynie myszy i przewijanie
                
                if (e.getValueIsAdjusting()) 
                    System.out.println("Trzymam button myszy"); //trzymamy
                else
                    System.out.println("Póściłem button myszy"); //puszczamy
                
                if (!e.getValueIsAdjusting()) //po wybraniu
                {
                    Object[] wartosciWLiscie = ((JList)e.getSource()).getSelectedValues(); //tablica obiektow wartosci w liscie
                    
                    String przedmioty = ""; 
                    
                    for (int i = 0; i < wartosciWLiscie.length; i++) //dodawanie do stringa wybrane kilka przedmiotow
                        przedmioty += (String)wartosciWLiscie[i]+" "; //z ctrl mozemy wybrac kilka!
                    
                    System.out.println(przedmioty); //wybrany 1 lub kilka przedmiotow
                    
                    komunikat.setText("Wybrany: "+przedmioty); //wyswielta w app: wybrany 1 lub kilka przedmiotow
                }
            }
        });
        
        final DefaultListModel modelListy = new DefaultListModel(); //domyslny model listy
        
        final String[] tekst = new String[]{"L2Item1","L2Item2"};
        
        modelListy.addElement("Element A"); //dodajemy elementy do modelu listy
        modelListy.addElement("Element B");
        modelListy.addElement("Element C");
        
        JList lista2 = new JList(modelListy); //tworzymy druga liste
        
        lista2.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
             for (int i = 0; i < tekst.length; i++)
                modelListy.addElement(tekst[i]);
            }
        });

        //panelListy.add(listaPrzedmiotow); /3
        panelListy.add(scrollListy);
        panelKomunikatu.add(komunikat);                                         //mozna zaznaczac pozycje w liscie, z ctrl mozemy kilka
        //this.getContentPane().add(listaPrzedmiotow); //2. dodanie listy do szybki // i tyle wystarczy zeby poprostu wyswietlic liste w app
        this.getContentPane().add(panelListy, BorderLayout.NORTH); //4 elegancko wyswieli wyrozniona liste na srodku
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER); //komunikat
        this.getContentPane().add(lista2, BorderLayout.SOUTH); //druga lista na poludniu, na dole
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private int i = 0;                  //1. nowa tablica String - anonimowa bez nazwy
    private JList listaPrzedmiotow = new JList(new String[]{"Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8"});    
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow); //dodajemy scrolla do listy
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel();
    
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

