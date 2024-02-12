package F1Dziedziczenie;

import F2NadpisywanieMetodPolimorfizm.Potwor;

public class Ol15ProtectedPajak extends Potwor { //folder do Ol14, ten plik do Ol15 
                //zeby pokazac jak dziala protected w innym folderze gdy jest dziedziczenie

    void funkcja()
    {
        this.HP = 1; //dostene z protected klasy Potwor
    }
    
}
