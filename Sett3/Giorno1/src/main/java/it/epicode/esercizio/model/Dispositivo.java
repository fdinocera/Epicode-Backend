package it.epicode.esercizio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.esercizio.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dispositivo {

    @Id
    @GeneratedValue
    int id;

    String nome;
    String tipo;

    StatoDispositivo statoDispositivo;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    Dipendente dipendente;
}
