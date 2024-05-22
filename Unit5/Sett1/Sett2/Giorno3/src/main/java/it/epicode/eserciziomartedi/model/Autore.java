package it.epicode.eserciziomartedi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Autore {

    @Id
    @GeneratedValue
    private int id;

    //private static int counter;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    @OneToMany(mappedBy = "autore")
    private List<Post> posts;


//    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
//        this.nome = nome;
//        this.cognome = cognome;
//        this.email = email;
//        this.dataDiNascita = dataDiNascita;
//        //counter++;
//        //id = counter;
//    }
}
