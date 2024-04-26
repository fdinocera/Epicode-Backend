import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Catalogo {

    Set<Pubblicazione> pubblicazioni = new HashSet<>();

    public void inserisciPubblicazione(Pubblicazione pubblicazione) {
        pubblicazioni.add(pubblicazione);
    }

    public boolean rimuoviPubblicazione(String codiceISBN) {
        return pubblicazioni.removeIf(p -> p.getCodiceISBN().equals(codiceISBN));
    }

    int getNumeroPubblicazioni() {
        return pubblicazioni.size();
    }

    public Optional<Pubblicazione> ricercaPerISBN(String codiceISBN) {

        Optional<Pubblicazione> result = pubblicazioni.stream()
                .filter(p -> p.getCodiceISBN().equals(codiceISBN))
                .findFirst();

        return result;
    }


}
