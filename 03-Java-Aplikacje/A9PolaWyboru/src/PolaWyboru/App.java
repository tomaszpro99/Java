package PolaWyboru;
import javax.swing.*;

import java.awt.*;

public class App extends JFrame {

    public App() {

        initComponents();

    }

    public void initComponents() {

        this.setTitle("Pola wyboru");
        this.setBounds(200, 200, 320, 240);

        panel1.add(pogrubiony);
        panel1.add(pochylony);

        panel2.add(etykieta);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);

        this.setDefaultCloseOperation(3);
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JCheckBox pogrubiony = new JCheckBox("Pogrubiony");
    JCheckBox pochylony = new JCheckBox("Pochylony");

    JLabel etykieta = new JLabel("Jestem piekna");

    public class CheckBoxHandler implements ActionListener {

        
    }

    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}

