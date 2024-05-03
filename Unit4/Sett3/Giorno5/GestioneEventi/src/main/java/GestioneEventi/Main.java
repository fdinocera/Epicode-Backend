package GestioneEventi;


import GestioneEventi.Entity.*;
import GestioneEventi.dao.EventoDao;
import GestioneEventi.dao.LocationDao;
import GestioneEventi.dao.PartecipazioneDao;
import GestioneEventi.dao.PersonaDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();

        LocationDao locationDao = new LocationDao(em);
        EventoDao eventoDao = new EventoDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);
        PersonaDao personaDao = new PersonaDao(em);


//        Location loc1 = new Location();
//        loc1.setCitta("Roma");
//        loc1.setNome("Circo Massimo");
//        locationDao.save(loc1);
//
//        Location loc2 = new Location();
//        loc2.setCitta("Napoli");
//        loc2.setNome("Mostra Oltremare");
//        locationDao.save(loc2);
//
//        Evento ev1 = new Evento();
//        ev1.setTitolo("Concerto 1 Maggio");
//        ev1.setTipoEvento(TIPO_EVENTO.PUBBLICO);
//        ev1.setDescrizione("Rassegna musicale");
//        ev1.setNumeroMassimoPartecipanti(50000);
//        ev1.setDataEvento(LocalDate.of(2024,5,1));
//        eventoDao.save(ev1);
//
//        Evento ev2 = new Evento();
//        ev2.setTitolo("Mostra Fumetto");
//        ev2.setTipoEvento(TIPO_EVENTO.PUBBLICO);
//        ev2.setDescrizione("Rassegna editoriale");
//        ev2.setNumeroMassimoPartecipanti(10000);
//        ev2.setDataEvento(LocalDate.of(2024,4,25));
//        eventoDao.save(ev2);
//
//        Persona p1 = new Persona();
//        p1.setCognome("Rossi");
//        p1.setNome("Paolo");
//        p1.setEmail("paolo@rossi.com");
//        p1.setSesso(SESSO.MASCHILE);
//        p1.setDataNascita(LocalDate.of(1965,6,4));
//        personaDao.save(p1);
//
//        Persona p2 = new Persona();
//        p2.setCognome("Bianchi");
//        p2.setNome("Francesco");
//        p2.setEmail("francesco@bianchi.com");
//        p2.setSesso(SESSO.MASCHILE);
//        p2.setDataNascita(LocalDate.of(1975,5,14));
//        personaDao.save(p2);
//
//        Partecipazione partecipazione1 = new Partecipazione();
//        partecipazione1.setEvento(ev1);
//        partecipazione1.setPersona(p1);
//        partecipazione1.setStatoPartecipazione(STATO_PARTECIPAZIONE.CONFERMATA);
//        partecipazioneDao.save(partecipazione1);
//
//        Partecipazione partecipazione2 = new Partecipazione();
//        partecipazione2.setEvento(ev2);
//        partecipazione2.setPersona(p2);
//        partecipazione2.setStatoPartecipazione(STATO_PARTECIPAZIONE.CONFERMATA);
//        partecipazioneDao.save(partecipazione2);

        //personaDao.getPersonaByName("Francesco").forEach(System.out::println);
        //personaDao.getPersonaByCognome("Rossi").forEach(System.out::println);

        Evento evento = eventoDao.getById(40);

        partecipazioneDao.getPersonaByEvento(evento).forEach(System.out::println);

        System.out.println("conteggio: " + partecipazioneDao.countPersonaByEvento(evento));

        personaDao.getPersonaByPartName("o").forEach(System.out::println);

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
        partitaDiCalcio.setSquadraCasa("Inter");
        partitaDiCalcio.setSquadraOspite("Salernitata");
        partitaDiCalcio.setGoalCasa(1);
        partitaDiCalcio.setGoalOspite(3);
        partitaDiCalcio.setDescrizione("Inter-Salernitana");
        partitaDiCalcio.setTitolo("Partita Inter Salernitana");
        partitaDiCalcio.setNumeroMassimoPartecipanti(80000);
        partitaDiCalcio.setDataEvento(LocalDate.of(2026, 5, 6));

        eventoDao.save(partitaDiCalcio);

        Concerto concerto = new Concerto();
//        concerto.setGenere(Genere.pop);
        concerto.setInStreaming(false);
        concerto.setDescrizione("Concerto Harry Styles");
        concerto.setDataEvento(LocalDate.of(2024, 4, 4));
        concerto.setTipoEvento(TIPO_EVENTO.PUBBLICO);

        eventoDao.save(concerto);


        Query query = em.createQuery("select c from Concerto c where c.inStreaming=:valore");

        Query query2 = em.createQuery("select c from Concerto c where c.genere=:valore");

        Query query3 = em.createQuery("select p from PartitaDiCalcio p where p.goalCasa >p.goalOspite");

        Query query4 = em.createQuery("select g from GaraDiAtletica g where g.vincitore =:persona");


    }
}
