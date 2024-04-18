package Esercizio2;

public class DipendentePartTime extends Dipendente{

    public DipendentePartTime(String matricola, Double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    double calculateSalary(){
        return getStipendio();
    }
}
