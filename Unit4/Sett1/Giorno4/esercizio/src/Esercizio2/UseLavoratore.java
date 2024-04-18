package Esercizio2;

import Esercizio1.Dipendente;

public class UseLavoratore {

    public static void main(String[] args) {

        Dipendente[] lavoratori = new Dipendente[3];

        lavoratori[0] = new DipendenteFullTime("012a", 2100.00, Dipendente.Dipartimento.PRODUZIONE);
        lavoratori[1] = new DipendentePartTime("12bc", 1200.00, Dipendente.Dipartimento.AMMINISTRAZIONE);
        lavoratori[2] = new Dirigente("b2aa", 3400.00, Dipendente.Dipartimento.AMMINISTRAZIONE);

        double somma =0;
        for (int i = 0; i < lavoratori.length; i++) {
            somma+=lavoratori[i].calculateSalary();
        }
        System.out.println("Totale stipendi: " + somma);
    }
}