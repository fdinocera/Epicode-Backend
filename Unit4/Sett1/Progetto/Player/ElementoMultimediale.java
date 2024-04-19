package Player;

abstract public class ElementoMultimediale {
    private String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    abstract void esegui();
}
