package Esercizio3;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, Double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    double calculateSalary(){
        return getStipendio();
    }

    @Override
    public void checkIn() {
        System.out.println(getMatricola()+ " ha iniziato a lavorare");
    }
}
