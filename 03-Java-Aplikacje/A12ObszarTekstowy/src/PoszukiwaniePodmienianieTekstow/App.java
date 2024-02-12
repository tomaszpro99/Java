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
        this.setTitle("Przeszukiwacz Tekstu");
        this.setBounds(300, 300, 440, 280);
        
        panelSzukania.add(znajdz);
        panelSzukania.add(szukany);         //rzeczy w panelu szukania
        panelSzukania.add(etykietaI);
        panelSzukania.add(zamien);
        panelSzukania.add(etykietaNa);
        panelSzukania.add(nowyTekst);
        
        //obszarTekstowy.selectAll(); - zaznacza cały tekst
        //obszarTekstowy.select(0, 2);// - zaznacza obszar, podany od kąd do kąd
        //obszarTekstowy.replaceSelection("lala"); - zamienić obszar, który jest zaznaczony
        //obszarTekstowy.replaceRange("lala", 0, 3); - range z ang. zasięg, podmieniamy na string z danego obszaru
        //obszarTekstowy.insert("jakis tam", 18);
        //obszarTekstowy.append("dolaczone do konca");
        //obszarTekstowy.select(obszarTekstowy.getText().indexOf("test"), obszarTekstowy.getText().indexOf("test")+"test".length());
        
        znajdz.addActionListener(new znajdowanieHandler()); //oblsuga znajdowania
        zamien.addActionListener(new zamienianieHandler()); //oblsuga zamieniania
        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH); //txt
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER); //menu

        this.setDefaultCloseOperation(3);
    }

    private class znajdowanieHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)  //oblsuga
        {
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(), poczatekSzukanego+szukany.getText().length());
            // pobieramy obszar tekstowy i w teksie pobieramy 1 indeks stringa ktorego bedziemy szukac, czyli pobierz txt szukanego //ktory jest tutaj: private JTextField szukany = new JTextField(5);
            System.out.println(poczatekSzukanego); // -1 -> nie znalazlo
            if (poczatekSzukanego == -1) //jak zobaczy ze jest -1
                poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());//sprawdzi jeszcze raz index, lepsze szukanie
            
            if (poczatekSzukanego >= 0 && szukany.getText().length() > 0)
            {
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego+szukany.getText().length());
            }
            
            
        }
        private int poczatekSzukanego = 0;
    }
    
    
    private class zamienianieHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {   //jezeli jest cos zaznaczone, mozemy wykonac zwykle zamienTekst
            if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
            {
               zamienTekst();
            }
            else //jezeli nie jest zaznaczone nic, wyreczy, żeby nie trzeba bylo pierw szukac, tylko od razu zmiana
            {
                znajdz.doClick(0); //zasymuluj klikniecie w znajdz //nie bedzie brzydkiego efektu klikniecia
                if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
                  zamienTekst(); // -//-
            }
        }
        
        private void zamienTekst()
        {
            obszarTekstowy.requestFocus();
            //JOptionPane, otworz okno potwierdzenia - czy chcemy podmienic txt, title, JOptionPane.YES_NO_OPTION wybor opcji)
            int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy chcesz zamienić \""+szukany.getText()+"\" na \""+nowyTekst.getText()+"\"", "Okno potwierdzenia", JOptionPane.YES_NO_OPTION);
            if (opcja == 0) // YES = 0, NO = 1, CANEL=2 JOptionPane.YES_NO_OPTION
              obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd()); //podmien tekst, nowy tekst, od kad do kad
        }
    }    
    private JTextArea obszarTekstowy = new JTextArea("hej asd",7, 10); //rozmiar okienka, domyslny txt
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy); //przewiajanie

    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdź");
    private JLabel etykietaI = new JLabel("i");
    private JButton zamien = new JButton("Zamień");
    private JLabel etykietaNa = new JLabel("na");   
    
    private JTextField szukany = new JTextField(5); //dlugosc okienek do wpisania
    private JTextField nowyTekst = new JTextField(5);

    public static void main(String[] args)
    {
        new App().setVisible(true);
    }
    
}

