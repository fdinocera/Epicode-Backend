package GestioneEventi.Entity;

import net.bytebuddy.implementation.bytecode.ShiftRight;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persone")
@NamedQuery(name = "getPersonaByName", query="select p from Persona p where p.nome= :nome")
public class Persona {

    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private SESSO sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    @OneToMany(mappedBy = "vincitore")
    private List<GaraDiAtletica> gareVinte;

    @ManyToMany
    @JoinTable(name = "atleta_gara",
            joinColumns = @JoinColumn(name = "atleta_id"),
            inverseJoinColumns = @JoinColumn(name = "gara_id"))

    private List<GaraDiAtletica> gareDiAtletica;

    public Persona(int id, String nome, String cognome, String email, LocalDate dataNascita, SESSO sesso) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public SESSO getSesso() {
        return sesso;
    }

    public void setSesso(SESSO sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                '}';
    }
}
