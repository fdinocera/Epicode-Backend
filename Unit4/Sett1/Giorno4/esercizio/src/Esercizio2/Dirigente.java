package Esercizio2;

public class Dirigente extends Dipendente{
    public Dirigente(String matricola, Double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    double calculateSalary(){
        return getStipendio();
    }
}
