package ECommerce;

public class Articolo {
    String codiceArticolo;
    String descrizioneArticolo;
    double prezzo;
    int quantitaDisponibile;

    Articolo(String codiceArticolo, String descrizioneArticolo, Double prezzo, int quantitaDisponibile){
        this.codiceArticolo=codiceArticolo;
        this.descrizioneArticolo=descrizioneArticolo;
        this.prezzo=prezzo;
        this.quantitaDisponibile=quantitaDisponibile;
    }
}
