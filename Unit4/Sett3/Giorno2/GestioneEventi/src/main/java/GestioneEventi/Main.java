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

        EventoDao dao = new EventoDao(em);

        Evento ev1 = new Evento();

        ev1.setDataEvento(LocalDate.of(2024, 04, 30));
        ev1.setTitolo("Inizio JPA");
        ev1.setDescrizione("Programmazione databse java");
        ev1.setTipoEvento(TIPO_EVENTO.PRIVATO);
        ev1.setNumeroMassimoPartecipanti(38);

        //crea evento ad ogni esecuzione
        dao.save(ev1);

        //recupera evento con id=1
        Evento ev2 = dao.getById(1);
        //System.out.println(ev2);

        //cancella evento ev2 (con id=1)
        dao.delete(ev2);
    }
}
