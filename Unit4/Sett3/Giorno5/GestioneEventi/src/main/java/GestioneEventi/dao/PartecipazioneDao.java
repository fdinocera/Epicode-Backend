package GestioneEventi.dao;

import GestioneEventi.Entity.Evento;
import GestioneEventi.Entity.Partecipazione;
import GestioneEventi.Entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

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

    public List<Persona> getPersonaByEvento(Evento evento) {
        Query query = em.createNamedQuery("getPersonaByEvento");
        query.setParameter("evento", evento);
        return query.getResultList();
    }
    public Long countPersonaByEvento(Evento evento){
        Query query = em.createQuery("select count(part) from Partecipazione part where part.evento=:evento");
        query.setParameter("evento", evento);
        return (Long)query.getSingleResult();
    }


}
