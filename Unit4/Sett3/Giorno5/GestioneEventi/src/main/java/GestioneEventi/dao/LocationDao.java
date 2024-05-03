package GestioneEventi.dao;

import GestioneEventi.Entity.Evento;
import GestioneEventi.Entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDao {

    EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
    }

    public Location getById(int id) {
        Location location = em.find(Location.class, id);
        return location;
    }

    public void delete(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }
}
