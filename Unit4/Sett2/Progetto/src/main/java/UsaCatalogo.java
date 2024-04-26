import java.util.Optional;

public class UsaCatalogo {

    public static void main(String[] args) {

        //elenco pubblicazioni
        Libro l1 = new Libro("97888227362", "I pirati della Malesia", 1966, 224, "Emilio Salgari", "Avventura");
        Libro l2 = new Libro("87888227362", "L'isola del tesoro", 1874, 132, "Robert Luis Stevenson", "Avventura");
        Libro l3 = new Libro("78188227362", "L'isola di Arturo", 1976, 302, "Elsa Morante", "Romanzo");

        Rivista r1 = new Rivista("68188227362", "Salute e benessere", 1980, 64, PERIODICITA.MENSILE);
        Rivista r2 = new Rivista("58188227362", "Modellismo", 1993, 32, PERIODICITA.SETTIMANALE);
        Rivista r3 = new Rivista("48188227362", "Astronomia", 1987, 128, PERIODICITA.SEMESTRALE);

        //creazione catalogo
        Catalogo catalogo = new Catalogo();

        //inserimento pubblicazioni
        catalogo.inserisciPubblicazione(l1);
        catalogo.inserisciPubblicazione(r1);
        catalogo.inserisciPubblicazione(l3);
        catalogo.inserisciPubblicazione(r3);


        //stampa totale pubblicazioni
        System.out.println("Totale pubblicazioni: " + catalogo.getNumeroPubblicazioni());

        //rimozione pubblicazione
        if (catalogo.rimuoviPubblicazione("78188227362")) {
            System.out.println("Rimozione pubblicazione avvenuta con successo!");
        } else {
            System.out.println("Rimozione pubblicazione non eseguita! (pubblicazione non trovata)");
        }


        //Ricerca per ISBN
        String codiceRicercaISBN = "48188227362";
        Optional<Pubblicazione> p1 = catalogo.ricercaPerISBN(codiceRicercaISBN);
        if (p1.isPresent()) {
            System.out.println(p1.get() + " trovato!");
        } else {
            System.out.println("Codice ISBN " + codiceRicercaISBN + " non trovato!");
        }




    }
}
