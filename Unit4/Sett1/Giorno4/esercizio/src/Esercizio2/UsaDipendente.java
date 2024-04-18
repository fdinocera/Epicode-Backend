package Esercizio2;

public class UsaDipendente {

    public static void main(String[] args) {

        Dipendente[] dipendenti = new Dipendente[3];

        dipendenti[0] = new DipendenteFullTime("123a", 1800.0, Dipartimento.PRODUZIONE);
        dipendenti[1] = new DipendentePartTime("321b", 1300.0, Dipartimento.AMMINISTRAZIONE);
        dipendenti[2] = new Dirigente("213c", 3000.0, Dipartimento.VENDITE);

        double somma=0;
        for (int i = 0; i < dipendenti.length; i++) {
            somma += dipendenti[i].getStipendio();
        }
        System.out.println("totale spipendi " + somma);
    }
}
