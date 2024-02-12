package A2Obiekto;

import java.util.Date;

public class Ol20FinalKeyword 
{
    public static void main(String[] args) 
    {
        final double PI;
        PI = 3.14;
        System.out.println(PI); //warning
        
        Pracownik888 asd = new Pracownik888();
        System.out.println(asd.dataZatrudnienia);
    }   
}

abstract class Osoba555{
}

class Pracownik888 extends Osoba555{
    Pracownik888() {
        this.dataZatrudnienia = new Date();
    }

    Pracownik888(Date data) {
        this.dataZatrudnienia = data;
    }

    final Date getDataZatrudnienia() {
        return this.dataZatrudnienia;
    }

    final Date dataZatrudnienia;
}

class Programista extends Pracownik888{ 
}
