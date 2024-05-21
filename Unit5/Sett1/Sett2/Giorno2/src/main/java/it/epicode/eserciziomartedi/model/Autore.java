package it.epicode.eserciziomartedi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {

    int id;
    static int counter;
    String nome;
    String cognome;
    String email;
    LocalDate dataDiNascita;
    String avatar;


    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        //this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
        counter++;
        id = counter;
    }
}
