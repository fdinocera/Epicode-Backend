package it.epicode.eserciziomartedi.model;

import lombok.Data;

@Data
public class Post {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
    private static int counter;


    public Post(String categoria, String titolo, String cover, String contenuto, int tempoDiLettura, int autoreId) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.autoreId = autoreId;
        counter++;
        id = counter;
    }
}
