package Suwaki;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App extends JFrame
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Suwaki");
        this.setBounds(300, 300, 300, 200);
        wartoscSuwaka.setEditable(false); //brak dostepu do edycji tabeli z wartoscia zakresu, jedynie suwak
        
        suwak.setMajorTickSpacing(5); //co ile zakres
        suwak.setMinorTickSpacing(1); //mniejszy zakres
        suwak.setPaintTicks(true); //widocznosc zakresu
        suwak.setPaintLabels(true); //widocznosc cyfr zakresu
        suwak.setSnapToTicks(true); //przeskakuje, nie plywa
      
        suwak.addChangeListener(new ChangeListener() { // sluchacz ktory bedzie sluchal

            public void stateChanged(ChangeEvent e) //jezeli cos sie stanie, stworzony zostanie obiekt ChangeEvent 
            {                                       //ktory zostanie wyslany do zmiennej e
                wartoscSuwaka.setText(""+((JSlider)e.getSource()).getValue());
                                        //2rzutowanie//1kto wywolal//3(2,1).pobierzWartosc()
                //1.zmienna//2zmien tekst/3 1.2(""+to wyzej)

                //zwiekszanie czcionki suwakiem
                tekst.setFont(new Font(tekst.getFont().getFontName(), tekst.getFont().getStyle(), ((JSlider)e.getSource()).getValue()));
            }//teskt, zmienamy czcione, tworzymy nowy obiekt czcionki
        }); // (Ustawiamy na taka co byla poprzednio, getFont,getFontName // ustawiamy styl //pobierz wartosc z JSlider JSuwak)
        this.getContentPane().add(suwak, BorderLayout.NORTH); //dodajemy suwak do szybki POLNOC
        this.getContentPane().add(tekst, BorderLayout.CENTER); //srodek test
        this.getContentPane().add(wartoscSuwaka, BorderLayout.SOUTH); //poludnie wart
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JSlider suwak = new JSlider(JSlider.HORIZONTAL, 0, 30, 5); //suwak zakres domyslna wartosc
    JTextField wartoscSuwaka = new JTextField(""+suwak.getValue()); //wartosc cyfrowa suwaka
    JLabel tekst = new JLabel("cos");//tekst
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

