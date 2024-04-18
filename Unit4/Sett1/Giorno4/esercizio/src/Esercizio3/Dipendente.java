package Esercizio3;

abstract public class Dipendente implements interfacciaLavoratore {

    private String matricola;
    private Double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String matricola, Double stipendio, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public String getMatricola() {
        return matricola;
    }

    public Double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

}
