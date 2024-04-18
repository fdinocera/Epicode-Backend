package Esercizio3;

public class UsaDipendente {

    public static void main(String[] args) {

        Dipendente[] dipendenti = new Dipendente[4];

        dipendenti[0] = new DipendenteFullTime("123X", 1800.0, Dipartimento.PRODUZIONE);
        dipendenti[1] = new DipendentePartTime("321Y", 1300.0, Dipartimento.AMMINISTRAZIONE);
        dipendenti[2] = new Dirigente("213Z", 3000.0, Dipartimento.VENDITE);
        dipendenti[3] = new Volontario("",0.0,Dipartimento.PRODUZIONE,"Luca",25,"ABCD");

        for (int i = 0; i < dipendenti.length; i++) {
            dipendenti[i].checkIn();
        }
    }
}
