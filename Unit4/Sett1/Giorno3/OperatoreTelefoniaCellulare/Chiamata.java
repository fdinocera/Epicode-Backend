package OperatoreTelefoniaCellulare;

public class Chiamata {
    private int numero;
    private int minutiConversazione;

    public Chiamata(int numero, int minutiConversazione) {
        this.numero = numero;
        this.minutiConversazione = minutiConversazione;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMinutiConversazione() {
        return minutiConversazione;
    }

    public void setMinutiConversazione(int minutiConversazione) {
        this.minutiConversazione = minutiConversazione;
    }
}
