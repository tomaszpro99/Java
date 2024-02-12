package FlowLayout_i_Panele;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {

        super("FlowLayout oraz Panele");
        this.setBounds(200, 200, 640, 480);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {

        button1.setPreferredSize(new Dimension(100, 100));
        button2.setPreferredSize(button2.getPreferredSize());

        panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //ustawiamy orientacje panelu

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        //Container kontener = getContenerPane(); //poprzednio uzywalismy //pobierz kontent szybki(pane)(że szyby xd)
        //uzywamy this bo jest to metoda naszej ramki JFrame
        //this.getContentPane().add(new JButton("la"), BorderLayout.PAGE_START);
        this.getContentPane().add(panel1, BorderLayout.CENTER);
    }
                                            // orientacja zalezy od tego RIGHT, LEFT, TRAILING
    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEADING)); //Flow - strumieniowy uklad menadzerow, oplywowy

    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}
