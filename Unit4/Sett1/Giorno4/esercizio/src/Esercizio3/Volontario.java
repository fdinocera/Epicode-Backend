package Esercizio3;



public class Volontario extends Dipendente implements interfacciaLavoratore {

    private String nome;
    private int eta;
    private String CV;

    public Volontario(String matricola, Double stipendio, Dipartimento dipartimento, String nome, int eta, String CV) {
        super(matricola, stipendio, dipartimento);
        this.nome = nome;
        this.eta = eta;
        this.CV = CV;
    }

    @Override
    public void checkIn() {
        System.out.println(nome + " ha iniziato a lavorare");
    }
}
