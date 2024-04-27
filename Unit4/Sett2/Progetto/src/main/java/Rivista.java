public class Rivista extends Pubblicazione {

    private PERIODICITA periodicita;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, PERIODICITA periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public PERIODICITA getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(PERIODICITA periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() + "; Periodicità: " + periodicita + "}";
    }
}
