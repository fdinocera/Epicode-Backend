package GestioneEventi.dao;

import GestioneEventi.Entity.Evento;
import jdk.jfr.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {

    EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

    public Evento getById(int id) {
        Evento ev = em.find(Evento.class, id);
        return ev;
    }

    public void delete(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }
}
