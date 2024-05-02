package GestioneEventi;


import GestioneEventi.Entity.Evento;
import GestioneEventi.Entity.TIPO_EVENTO;
import GestioneEventi.dao.EventoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();

//        EventoDao dao = new EventoDao(em);
//        Evento ev1 = new Evento();
//
//        ev1.setDataEvento(LocalDate.of(2024, 5, 1));
//        ev1.setTitolo("Concerto 1 Maggio");
//        ev1.setDescrizione("Rassegna musicale");
//        ev1.setTipoEvento(TIPO_EVENTO.PUBBLICO);
//        ev1.setNumeroMassimoPartecipanti(50000);
//
//        dao.save(ev1);




    }
}
