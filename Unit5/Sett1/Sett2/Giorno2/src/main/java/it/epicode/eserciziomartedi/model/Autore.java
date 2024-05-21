package it.epicode.eserciziomartedi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {

    private int id;
    private static int counter;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;


    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        counter++;
        id = counter;
    }
}
