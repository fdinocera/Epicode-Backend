package Catalogo;

import Catalogo.Dao.PrestitoDao;
import Catalogo.Dao.PubblicazioneDao;
import Catalogo.Dao.UtenteDao;
import Catalogo.Entity.*;
import Catalogo.Enums.PERIODICITA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");
        EntityManager em = emf.createEntityManager();

        PubblicazioneDao pubblicazioneDao = new PubblicazioneDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);


        // 1) Aggiunta elementi al catalogo
//        Pubblicazione p1 = new Libro("97888227362", "I pirati della Malesia", 1966, 224, "Emilio Salgari", "Avventura");
//        pubblicazioneDao.save(p1);
//
//        Pubblicazione p2 = new Libro("87888227362", "L'isola del tesoro", 1881, 132, "Robert Luis Stevenson", "Avventura");
//        pubblicazioneDao.save(p2);
//
//        Pubblicazione p3 = new Libro("78188227362", "L'isola di Arturo", 1980, 302, "Elsa Morante", "Romanzo");
//        pubblicazioneDao.save(p3);
//
//        Pubblicazione p4 = new Libro("71288227362", "Sandokan", 1966, 302, "Emilio Salgari", "Romanzo");
//        pubblicazioneDao.save(p4);
//
//        Pubblicazione p5 = new Rivista("68188227362", "Salute e benessere", 1980, 64, PERIODICITA.MENSILE);
//        pubblicazioneDao.save(p5);
//
//        Pubblicazione p6 = new Rivista("58188227362", "Modellismo", 1985, 32, PERIODICITA.SETTIMANALE);
//        pubblicazioneDao.save(p6);
//
//        Pubblicazione p7 = new Rivista("48188227362", "Astronomia", 1966, 128, PERIODICITA.SEMESTRALE);
//        pubblicazioneDao.save(p7);
//
//        Pubblicazione p8 = new Rivista("38188227362", "Chimica", 1966, 138, PERIODICITA.SEMESTRALE);
//        pubblicazioneDao.save(p8);
//
//        //creazione utenti
//        utenteDao.save(new Utente("Mario", "Rossi", LocalDate.of(1966, 5, 28), 347));
//        utenteDao.save(new Utente("Francesco", "Taranto", LocalDate.of(1956, 8, 25), 349));
//        utenteDao.save(new Utente("Luigi", "Milano", LocalDate.of(1969, 7, 21), 357));
//        utenteDao.save(new Utente("Andrea", "Torino", LocalDate.of(1977, 6, 18), 366));


        // 2) Rimozione da catalogo con ISBN
//        int recordEliminato = pubblicazioneDao.removeByIsbn("9788822736200");
//        if (recordEliminato == 1) {
//            System.out.println("Rimozione per isbn: record eliminato correttamente");
//        } else {
//            System.out.println("Rimozione per isbn: nessun record eliminato");
//        }
//        System.out.println();

        // 3) Ricerca per ISBN
        String isbnSearch = "97888227362";
        Pubblicazione p = pubblicazioneDao.searchByIsbn(isbnSearch);
        if (p == null) {
            System.out.println("Ricerca per isbn: " + isbnSearch);
            System.out.println("Nessuna pubblicazione trovata");
        } else {
            System.out.println("Ricerca per isbn " + isbnSearch);
            System.out.println(p);
        }
        System.out.println();

        // 4) Ricerca per anno di pubblicazione
        int annoPubblicazione = 1980;
        List<Pubblicazione> lista1 = pubblicazioneDao.searchByYearPublishing(annoPubblicazione);
        System.out.println("Ricerca per anno di pubblicazione: " + annoPubblicazione);
        lista1.forEach(System.out::println);
        System.out.println();

        // 5) Ricerca per autore
        String autore = "Emilio Salgari";
        List<Pubblicazione> lista2 = pubblicazioneDao.searchByAuthor(autore);
        System.out.println("Ricerca per autore: " + autore);
        lista2.forEach(System.out::println);
        System.out.println();

        // 6) Ricerca per titolo o parte del titolo
        String searchText = "isol";
        List<Pubblicazione> lista3 = pubblicazioneDao.searchByPartTitle(searchText);
        System.out.println("Ricerca per titolo o parte del titolo: " + searchText);
        lista3.forEach(System.out::println);
        System.out.println();

        // 7) Ricerca elementi in prestito con numero tessera
        int tessera = 347;
        System.out.println("Pubblicazioni in prestito per tessera: " + tessera);
        List<Pubblicazione> lista4 = prestitoDao.getElementiInPrestito(tessera);
        lista4.forEach(System.out::println);
        System.out.println();

        // 8) Ricerca prestiti scaduti e non restituiti
        System.out.println("Prestiti scaduti e non restituiti");
        List<Prestito> lista5 = prestitoDao.getPrestitiScadutiNonRestituiti();
        lista5.forEach(System.out::println);
    }
}
