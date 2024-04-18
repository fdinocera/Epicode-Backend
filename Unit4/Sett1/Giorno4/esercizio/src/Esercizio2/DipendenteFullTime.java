package Esercizio2;

import Esercizio1.Dipendente;

public class DipendenteFullTime extends Dipendente {


    public DipendenteFullTime(String matricola, Double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendio();
    }
}
