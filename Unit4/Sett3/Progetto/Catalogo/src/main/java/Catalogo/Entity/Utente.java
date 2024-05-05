package Catalogo.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    int id;

    private int numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;


    //////////////////////////////////////////////
    @OneToMany(mappedBy = "utente")
    List<Prestito> prestiti;
    //////////////////////////////////////////////

    public Utente(String nome, String cognome, LocalDate dataDiNascita, int numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTessera = numeroTessera;
    }
    public Utente(){

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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroTessera='" + numeroTessera + '\'' +
                '}';
    }
}
