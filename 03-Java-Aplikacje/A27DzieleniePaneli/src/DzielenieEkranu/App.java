package DzielenieEkranu;

import javax.swing.*;
//import java.awt.*;
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
        this.setTitle("Podzielenie paneli");
        this.setBounds(300, 300, 320, 240);

        panelListy.add(lista);
        panelObrazka.add(obrazek);
        panelOpisu.add(opis);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting())
                {
                    Obrazek img = (Obrazek)((JList)e.getSource()).getSelectedValue();
                    
                    obrazek.setIcon(img.getImage());
                    opis.setText(img.getDescription());
                }
            }
        });
        JSplitPane podzielenie = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListy, panelObrazka); //podzielenie ekranu na2 
        JSplitPane podzielenieGlowne = new JSplitPane(JSplitPane.VERTICAL_SPLIT, podzielenie, panelOpisu); //podzielenie ekranu na3
        
        this.getContentPane().add(podzielenieGlowne);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JPanel panelListy = new JPanel();
    JPanel panelObrazka = new JPanel();
    JPanel panelOpisu = new JPanel();
    JList lista = new JList(
        new Obrazek[]{   
            new Obrazek("niebieski", "piekny kolorek niebieski"),
            new Obrazek("czerwony", "piekny kolorek czerwony"),
            new Obrazek("zielony", "piekny kolorek zielony"),
        }
    );
    JLabel obrazek = new JLabel();
    JLabel opis = new JLabel();
    
    private class Obrazek
    {
        public Obrazek(String nazwa, String opis)
        {
            this.nazwa = nazwa;
            this.opis = opis;
            
            obrazek = new ImageIcon(nazwa+".gif");
        }
        public String toString()
        {
            return nazwa;
        }
        public ImageIcon getImage()
        {
            return obrazek;
        }
        public String getDescription()
        {
            return opis;
        }
        
        String nazwa, opis;
        ImageIcon obrazek;
    }
    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    

}

