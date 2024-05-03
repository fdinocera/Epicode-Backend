package GestioneEventi.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {


    @ManyToMany(mappedBy = "gareDiAtletica")
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;


    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica() {
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}

