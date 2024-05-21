package it.epicode.eserciziomartedi.model;

import lombok.Data;

@Data
public class Post {
    int id;
    String categoria;
    String titolo;
    String cover;
    String contenuto;
    int tempoDiLettura;
    Autore autore;
    static int counter;


    public Post(String categoria, String titolo, String cover, String contenuto, int tempoDiLettura, Autore autore) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.autore = autore;
        counter++;
        id = counter;
    }
}
