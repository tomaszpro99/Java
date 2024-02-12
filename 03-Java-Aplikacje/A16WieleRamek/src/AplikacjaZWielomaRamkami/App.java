import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame {

    public App() {
        initComponents();
    }

    public void initComponents() {

        this.setTitle("App");
        this.setBounds(200, 200, 320, 240);

        nowaRamka.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                new dialog(taRamka).setVisible(true);
                //new NowaRamka(taRamka).setVisible(true); //jak w main
            } //kostruktor NowaRamka.java bedzie przyjmowal JFrame rodzica App.java (tej ramki)
        }); //musimy podac arg do new NowaRamka(x), nie mozemy this bo new ActionListener() to klasa wewnetrzna
            //wiecj bedziemy musieli uzyc zmiennej z zewnatrz

        this.getContentPane().add(nowaRamka);
        this.setDefaultCloseOperation(3);
    }
    //obszar "z zewnatrz"
    private JFrame taRamka = this;

    private JButton nowaRamka = new JButton("Stwórz ramke");

    public static void main(String[] args) throws Exception {
        new App().setVisible(true);
    }
}