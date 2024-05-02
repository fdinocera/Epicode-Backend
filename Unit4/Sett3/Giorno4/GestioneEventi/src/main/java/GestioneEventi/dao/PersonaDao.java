package GestioneEventi.dao;

//import GestioneEventi.Entity.Evento;
//import GestioneEventi.Entity.Partecipazione;
import GestioneEventi.Entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDao {

    EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(persona);
        et.commit();
    }

    public Persona getById(int id) {
        Persona persona = em.find(Persona.class, id);
        return persona;
    }

    public void delete(Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(persona);
        et.commit();
    }
}
