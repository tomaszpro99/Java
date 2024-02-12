package UkladGraficzny;
import javax.swing.*;

import java.awt.*;

public class App extends JFrame {

    public App() {

        super("Layout");
        this.setBounds(200, 200, 640, 480);

        initComponents();

        // this.pack(); //dostosuje rozmiar ramki do komponentow, obliczy se sam itp



        this.setDefaultCloseOperation(3);
    }

    public void initComponents() { //inicjacja komponentow

        PrzyciskCentrum = new JButton("Anuluj");
        PrzyciskGora = new JButton("Góra");
        PrzyciskDol = new JButton("Dół");
        PrzyciskLewo = new JButton("Lewo");
        PrzyciskPrawo = new JButton("Prawo");

        Container kontener = this.getContentPane(); //pobierz kontent szybki(pane)(że szyby xd)

        // kontener.add(PrzyciskCentrum, BorderLayout.CENTER); //domyslnie center
        // kontener.add(PrzyciskGora, BorderLayout.PAGE_START); //menadzer ukladow,
        // kontener.add(PrzyciskDol, BorderLayout.PAGE_END);    //setSize i Location bedzie ignorowanie
        // kontener.add(PrzyciskLewo, BorderLayout.LINE_START);
        // kontener.add(PrzyciskPrawo, BorderLayout.LINE_END);

        PrzyciskCentrum.setLocation(470,360);
        //PrzyciskCentrum.setSize(70,20);
        PrzyciskCentrum.setSize(PrzyciskCentrum.getPreferredSize());
        kontener.setLayout(null);
        kontener.add(PrzyciskCentrum);

    }

    JButton PrzyciskCentrum;
    JButton PrzyciskGora;
    JButton PrzyciskDol;
    JButton PrzyciskLewo;
    JButton PrzyciskPrawo;

    public static void main(String[] args) throws Exception {
        new App().setVisible(true);
    }
}
