package it.epicode.eserciziomartedi.DTO;

import lombok.Data;

@Data
public class PostDto {

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;
}
