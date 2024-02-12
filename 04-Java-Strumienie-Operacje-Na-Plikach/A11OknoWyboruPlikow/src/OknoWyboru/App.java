package OknoWyboru;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;


public class App extends JFrame
{
    public App()
    {
        this.setTitle("Okno wyboru plików");
        this.setBounds(250, 300, 320, 240);
        
        final JFileChooser wyborPlikow = new JFileChooser(); //FileWybieracz, tworzymy obiekt
        wyborPlikow.setCurrentDirectory(new File(System.getProperty("user.dir")+File.separator+"A11OknoWyboruPlikow"));
        wyborPlikow.setMultiSelectionEnabled(true); //multi wybor plikow
        
        wyborPlikow.setAcceptAllFileFilterUsed(true); //true- mozna kazdy typ pliku, all files
        
        wyborPlikow.setFileFilter(new FiltrRozszerzen("Pola tekstowe", ROZSZERZENIA_TEKSTOWE)); //masz filtr z tabica rozszerzen
        wyborPlikow.setFileFilter(new FileFilter() { //filtr folderow

            @Override
            public boolean accept(File f) {
                return f.isDirectory(); //zwroci prawde jezeli jest folderem
            }

            @Override
            public String getDescription() {
                return "Katalogi";  //opcja Katalogi w wyborze typu plikow
            }
        });
        button1.addActionListener(new ActionListener() { //jezeli ktos kliknie na buttona otworz

            public void actionPerformed(ActionEvent e) 
            {
                int tmp = wyborPlikow.showOpenDialog(rootPane); //dialog 
                if (tmp == 0)                                   //wybrany plik+otworz = 0, cancel = 1                                                  
                    stworzPlikZip(wyborPlikow.getSelectedFiles()); //stworzPlikZip(); stworzy sciezke
            }
        });
        
        button2.addActionListener(new ActionListener() { //do zapisu

            public void actionPerformed(ActionEvent e) 
            {
               wyborPlikow.showDialog(rootPane, "ZIP in that place");
                
            }
        });
        
        this.panelButtonow.add(button1);
        this.panelButtonow.add(button2);
        
        this.getContentPane().add(panelButtonow); //panel buttonow
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private JPanel panelButtonow = new JPanel(); 
    private JButton button1 = new JButton("Otwórz");
    private JButton button2 = new JButton("Zapisz");
    
    public void stworzPlikZip(File[] pliki) //tu zostana przyjete pliki po "otworz"
    {
        for (int i = 0; i < pliki.length; i++)
            System.out.println(pliki[i].getPath()); //wyswietlamy sciezke
    }
    public static void main(String[] args) {
        new App().setVisible(true);
    }
    
    private final String[] ROZSZERZENIA_TEKSTOWE = new String[]{".txt", ".xml", ".mf"}; //ROZSZERZENIA TEKSTOWE DO FILTRU
    private class FiltrRozszerzen extends FileFilter //nasza klasa do tworzenia Filtru Rozszerzen
    {
        public FiltrRozszerzen(String opis, String[] rozszerzenia){
            this.opis = opis;
            this.rozszerzenia = rozszerzenia;                   
        }
        @Override
        public boolean accept(File f) {
            for (int i = 0; i < this.rozszerzenia.length; i++) //potworzy sie dla kazdego rozszerzenia
               if (f.getName().toLowerCase().endsWith(this.rozszerzenia[i]) || f.isDirectory()) //pliki tekstowe i foldery beda widoczne
                    return true; //Pobieramy imie z file, czy ma na koncu rozszerzenie z tablicy i czy jest bibioteka

            return false; //zwroci falsz jak nie znajdzie rozszerzenia
        }
        @Override
        public String getDescription() {
            return opis; //daj nazwe z wywolania
        }
        private String opis;
        private String[] rozszerzenia;
    }
}
