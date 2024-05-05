package Catalogo.Dao;

import Catalogo.Entity.Pubblicazione;
import Catalogo.Entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getById(int id) {
        Utente utente = em.find(Utente.class, id);
        return utente;
    }

    public void delete(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(utente);
        et.commit();
    }
}
