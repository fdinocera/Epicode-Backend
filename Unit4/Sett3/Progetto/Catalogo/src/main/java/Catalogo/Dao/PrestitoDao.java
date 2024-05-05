package Catalogo.Dao;

import Catalogo.Entity.Prestito;
import Catalogo.Entity.Pubblicazione;
import Catalogo.Entity.Utente;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {

    EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id) {
        Prestito prestito = em.find(Prestito.class, id);
        return prestito;
    }

    public void delete(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(prestito);
        et.commit();
    }

    public List<Pubblicazione> getElementiInPrestito(int tessera) {

        Query query = em.createQuery("SELECT pub " +
                " FROM Utente u" +
                " JOIN Prestito pr ON u.id=pr.utente" +
                " JOIN Pubblicazione pub ON pr.elementoPrestato=pub.id" +
                " WHERE u.numeroTessera=:tessera AND pr.dataRestituzioneEffettiva IS NULL");

        query.setParameter("tessera", tessera);
        return query.getResultList();
    }

    public List<Prestito> getPrestitiScadutiNonRestituiti() {

        Query query = em.createQuery("SELECT pr " +
                        "FROM Prestito pr " +
                        "WHERE pr.dataRestituzionePrevista < CURRENT_DATE " +
                        "AND pr.dataRestituzioneEffettiva IS NULL");

        return query.getResultList();
    }
}
