package ECommerce;

public class Articolo {
    private String codiceArticolo;
    private String descrizioneArticolo;
    private double prezzo;
    private int quantitaDisponibile;

//    Articolo(String codiceArticolo, String descrizioneArticolo, Double prezzo, int quantitaDisponibile) {
//        this.codiceArticolo = codiceArticolo;
//        this.descrizioneArticolo = descrizioneArticolo;
//        this.prezzo = prezzo;
//        this.quantitaDisponibile = quantitaDisponibile;
//    }


    public Articolo(String codiceArticolo, String descrizioneArticolo, double prezzo, int quantitaDisponibile) {
        this.codiceArticolo = codiceArticolo;
        this.descrizioneArticolo = descrizioneArticolo;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public String getCodiceArticolo() {
        return codiceArticolo;
    }

    public void setCodiceArticolo(String codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public String getDescrizioneArticolo() {
        return descrizioneArticolo;
    }

    public void setDescrizioneArticolo(String descrizioneArticolo) {
        this.descrizioneArticolo = descrizioneArticolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }
}
