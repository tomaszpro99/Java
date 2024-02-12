package GroupLayoutMenadzer;
import javax.swing.*;

import java.awt.*;

public class App extends JFrame {

    public App() {

        super("GroupLayout");
        this.setBounds(200, 200, 640, 480);

        initComponents();

        this.setDefaultCloseOperation(3);

    }

    public void initComponents() {

        GroupLayout layout1 = new GroupLayout(getContentPane());

        this.getContentPane().setLayout(layout1);

        layout1.setAutoCreateGaps(true); //odstepy miedzy buttonami
        layout1.setAutoCreateContainerGaps(true); //odstepy od krawedzi


        layout1.setHorizontalGroup(
            layout1.createSequentialGroup() // .addComponent(nazwa, minimalna, preferowana, maksymalna wielkosc buttona)
            .addComponent(button1/* , GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE*/) //pierwsza sekwencja //rozszerzanie buttona
            .addGroup( //druga sekwencja - ParallelGrupu - grupa do siebie rownolegla
                layout1.createParallelGroup().addComponent(button2).addComponent(button4)
            )
            .addComponent(button3) //trzecia sekwencja

            //chcemy dodac staly anuluj w prawym dolnym
            .addContainerGap(10, Short.MAX_VALUE) //dziura kontenerowa (poczatkowa wielkosc, do kiedy ma sie rozszerzac)
            .addComponent(bAnuluj)
        );

        layout1.setVerticalGroup(
            layout1.createSequentialGroup()
            .addGroup( //ParallelGrupu - grupa do siebie rownolegla
                layout1.createParallelGroup().addComponent(button1/*, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE*/) //rozszerzanie buttona
                .addComponent(button2).addComponent(button3)
            )
            .addComponent(button4)
            //chcemy dodac staly anuluj w prawym dolnym
            .addContainerGap(10, Short.MAX_VALUE) //dziura kontenerowa (poczatkowa wielkosc, do kiedy ma sie rozszerzac)
            .addComponent(bAnuluj)
        );

        pack(); //dostosuj
    }

    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    JButton bAnuluj = new JButton("Anuluj");


    public static void main(String[] args) throws Exception {
        
        new App().setVisible(true);
    }
}
