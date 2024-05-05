package Catalogo.Dao;

import Catalogo.Entity.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class PubblicazioneDao {

    EntityManager em;

    public PubblicazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Pubblicazione pubblicazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pubblicazione);
        et.commit();
    }

    public Pubblicazione getById(int id) {
        Pubblicazione pubblicazione = em.find(Pubblicazione.class, id);
        return pubblicazione;
    }

    public void delete(Pubblicazione pubblicazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(pubblicazione);
        et.commit();
    }

    public int removeByIsbn(String Isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("DELETE Pubblicazione p WHERE p.codiceISBN=:Isbn");
        query.setParameter("Isbn", Isbn);

        int recordEliminati = query.executeUpdate();
        et.commit();
        return recordEliminati;
    }

    public Pubblicazione searchByIsbn(String Isbn) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.codiceISBN=:Isbn");
        query.setParameter("Isbn", Isbn);
        try {
            return (Pubblicazione) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Pubblicazione> searchByYearPublishing(int anno) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.annoPubblicazione=:anno");
        query.setParameter("anno", anno);

        return query.getResultList();
    }

    public List<Pubblicazione> searchByAuthor(String autore) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore=:autore");
        query.setParameter("autore", autore);

        return query.getResultList();
    }

    public List<Pubblicazione> searchByPartTitle(String titolo) {
        Query query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");

        List<Pubblicazione> l = query.getResultList();
        return query.getResultList();
    }
}
