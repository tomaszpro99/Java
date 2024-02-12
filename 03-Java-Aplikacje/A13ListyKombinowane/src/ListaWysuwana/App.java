package ListaWysuwana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame
{
    public App()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("app");
        this.setBounds(300, 300, 300, 200);
        
        kombinacja.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) 
            {
                //ColorHandler handler = (ColorHandler)((JComboBox)e.getSource()).getSelectedItem();
                //((JComboBox)e.getSource()).setBackground(handler.getColor());
            //rzutujemy na JCB//1pobieramy zrodl//3dostep do setBackground//4"handler.getColor"
                
                //skracamy                              //+ calosc w nawias + .getColor()
                ((JComboBox)e.getSource()).setBackground(((ColorHandler)((JComboBox)e.getSource()).getSelectedItem()).getColor());
            }
        });
        
        panel.add(kombinacja); //dodano kombnacje (lista wysuwana)
        //kombinacja.addItem(new String("nic")); ActionListener wymaga akcji
        kombinacja.addItem(new ColorHandler("Czarny", Color.BLACK));
        kombinacja.addItem(new ColorHandler("Zielony", Color.GREEN));
        kombinacja.addItem(new ColorHandler("Niebieski", Color.BLUE));
        kombinacja.addItem(new ColorHandler("Żółty", Color.YELLOW));
                            //nowy obiekt(string, color)

        this.getContentPane().add(panel); //szybka
        this.setDefaultCloseOperation(3);
    }
    private class ColorHandler 
    {
        public ColorHandler(String colorName, Color kolor) //przysylamy kolor
        {
            this.kolor = kolor; //do koloru w obiekcie przypiszemy kolor przyslany
            this.colorName = colorName;
        }
        @Override
        public String toString() //metoda istnieje w kazdej klasie, zwraca string, to co ma wypisac, a nie adres <3
        {
            return this.colorName;
        }
        public Color getColor()
        {
            return this.kolor;
        }
        private Color kolor;
        private String colorName; 
    }
    private JPanel panel = new JPanel();
    private JComboBox kombinacja = new JComboBox(); //pudeleczko do kombinacji
            //referencja obiektu = obiekt
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}