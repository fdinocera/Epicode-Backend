package GestioneEventi.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gestione_eventi")
public class Evento {

    @Id
    @GeneratedValue
    private int id;

    //@Column (nullable = false, length = 30)
    private String titolo;

    //@Column(nullable = false, name = "data_evento")
    private LocalDate dataEvento;

    //@Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    //@Column(name = "tipo_evento", nullable = false)
    private TIPO_EVENTO tipoEvento;

    //@Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> lista_partecipazione = new ArrayList<>();

    public Evento(int id, String titolo, LocalDate dataEvento, String descrizione, TIPO_EVENTO tipoEvento, int numeroMassimoPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TIPO_EVENTO getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TIPO_EVENTO tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
