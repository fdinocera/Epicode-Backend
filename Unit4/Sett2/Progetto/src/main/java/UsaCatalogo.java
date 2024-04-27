import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsaCatalogo {

    public static void main(String[] args) {

        //elenco pubblicazioni
        Libro l1 = new Libro("97888227362", "I pirati della Malesia", 1966, 224, "Emilio Salgari", "Avventura");
        Libro l2 = new Libro("87888227362", "L'isola del tesoro", 1881, 132, "Robert Luis Stevenson", "Avventura");
        Libro l3 = new Libro("78188227362", "L'isola di Arturo", 1980, 302, "Elsa Morante", "Romanzo");
        Libro l4 = new Libro("71288227362", "Sandokan", 1966, 302, "Emilio Salgari", "Romanzo");
        Rivista r1 = new Rivista("68188227362", "Salute e benessere", 1980, 64, PERIODICITA.MENSILE);
        Rivista r2 = new Rivista("58188227362", "Modellismo", 1985, 32, PERIODICITA.SETTIMANALE);
        Rivista r3 = new Rivista("48188227362", "Astronomia", 1966, 128, PERIODICITA.SEMESTRALE);

        //creazione catalogo
        Catalogo catalogo = new Catalogo();

        if (!catalogo.inserisciPubblicazione(l1)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(l2)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(l3)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(l4)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(r1)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(r2)) {
            System.out.println("pubblicazione non inserita");
        }
        if (!catalogo.inserisciPubblicazione(r3)) {
            System.out.println("pubblicazione non inserita");
        }

        //rimozione pubblicazione
        String rimozioneCodiceISBN = "78188227362";
        if (catalogo.rimuoviPubblicazione(rimozioneCodiceISBN)) {
            System.out.println("Rimozione pubblicazione ISBN " + rimozioneCodiceISBN + " avvenuta con successo!");
        } else {
            System.out.println("Rimozione pubblicazione ISBN " + rimozioneCodiceISBN + " non eseguita! (pubblicazione non trovata)");
        }
        System.out.println();

        //Ricerca per ISBN
        String codiceRicercaISBN = "48188227362";
        List<Pubblicazione> listaRicercaISBN = catalogo.ricercaPerISBN(codiceRicercaISBN);
        if (!listaRicercaISBN.isEmpty()){
            System.out.println("Ricerca per ISBN: " + codiceRicercaISBN);
            listaRicercaISBN.forEach(System.out::println);
        }else {
            System.out.println("Nessun risultato.");
        }
        System.out.println();

        //ricerca per anno pubblicazione
        int annoPubblicazione = 1966;
        List<Pubblicazione> listaAnnoPubblicazione = catalogo.ricercaAnnoPubblicazione(annoPubblicazione);
        System.out.println("Ricerca per anno pubblicazione: " + annoPubblicazione);
        if (!listaAnnoPubblicazione.isEmpty()) {
            listaAnnoPubblicazione.forEach(p -> System.out.println(p));
        }else {
            System.out.println("Nessun risultato.");
        }
        System.out.println();

        //ricerca per autore
        String autore = "emili";
        List<Pubblicazione> listaAutore = catalogo.ricercaPerAutore(autore);
        if (!listaAutore.isEmpty()) {
            System.out.println("Pubblicazioni trovate per autore: " + autore);
            listaAutore.forEach(p -> System.out.println(p));
        }else {
            System.out.println("Nessun risultato.");
        }
        System.out.println();

        //salvataggio archivio su file
        File file = new File("./../archivio.txt");
        String data = catalogo.toString();
        try {
            FileUtils.writeStringToFile(file, data, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //recupero dati da file
        try {
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());
            List<Pubblicazione> pubblicazioniDaFile = Arrays.stream(str.split("#"))
                    .map(record -> {
                        String[] campi = record.split("@");
                        if (campi.length == 6) { // Libro
                            return new Libro(campi[0], campi[1], Integer.parseInt(campi[2]), Integer.parseInt(campi[3]), campi[4], campi[5]);
                        } else if (campi.length == 5) { // Rivista
                            return new Rivista(campi[0], campi[1], Integer.parseInt(campi[2]), Integer.parseInt(campi[3]), PERIODICITA.valueOf(campi[4]));
                        } else {
                            throw new IllegalArgumentException("Formato dati non valido");
                        }
                    })
                    .collect(Collectors.toList());

            System.out.println("Recupero dati da file");
            pubblicazioniDaFile.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}