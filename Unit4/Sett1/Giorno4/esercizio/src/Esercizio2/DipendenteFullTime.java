package Esercizio2;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, Double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    double calculateSalary(){
        return getStipendio();
    }
}
