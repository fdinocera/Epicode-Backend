import java.util.*;
import java.util.stream.Collectors;


public class Catalogo {

    Set<Pubblicazione> pubblicazioni = new HashSet<>();

    public boolean inserisciPubblicazione(Pubblicazione pubblicazione) {
        return pubblicazioni.add(pubblicazione);
    }

    public boolean rimuoviPubblicazione(String codiceISBN) {
        return pubblicazioni.removeIf(p -> p.getCodiceISBN().equals(codiceISBN));
    }

//    public Optional<Pubblicazione> ricercaPerISBN(String codiceISBN) {
//
//        Optional<Pubblicazione> result = pubblicazioni.stream()
//                .filter(p -> p.getCodiceISBN().equals(codiceISBN))
//                .findFirst();
//        return result;
//    }

    public List<Pubblicazione> ricercaPerISBN(String codiceISBN) {
        return pubblicazioni.stream().filter(p -> p.getCodiceISBN() == codiceISBN).toList();
    }

    public List<Pubblicazione> ricercaAnnoPubblicazione(int anno) {
        return pubblicazioni.stream().filter(p -> p.getAnnoPubblicazione() == anno).toList();
    }

    public List<Pubblicazione> ricercaPerAutore (String autore){
        return pubblicazioni.stream()
                .filter(p -> p instanceof Libro && ((Libro) p).getAutore().toLowerCase().contains(autore.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return pubblicazioni.stream()
                .map(p -> p.getCodiceISBN() + "@" +
                        p.getTitolo() + "@" +
                        p.getAnnoPubblicazione() + "@" +
                        p.getNumeroPagine() +
                        (p instanceof Libro ? ("@" + ((Libro) p).getAutore() + "@" + ((Libro) p).getGenere()) :
                        (p instanceof Rivista ? ("@" + ((Rivista) p).getPeriodicita()) : "")))
                .collect(Collectors.joining("#"));
    }
}