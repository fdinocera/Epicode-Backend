package GestioneEventi.dao;

import GestioneEventi.Entity.Evento;
import GestioneEventi.Entity.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDao {
    EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
    }

    public Partecipazione getById(int id) {
        Partecipazione partecipazione = em.find(Partecipazione.class, id);
        return partecipazione;
    }

    public void delete(Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(partecipazione);
        et.commit();
    }
}
