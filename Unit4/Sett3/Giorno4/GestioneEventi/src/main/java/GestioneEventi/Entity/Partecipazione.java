package GestioneEventi.Entity;


import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private int id;

    //    @OneToMany
//    @JoinColumn(name = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private STATO_PARTECIPAZIONE statoPartecipazione;

    public Partecipazione(int id, Persona persona, Evento evento) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
    }

    public Partecipazione() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
