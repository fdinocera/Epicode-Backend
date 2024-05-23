package it.epicode.eserciziomartedi.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostDto {

    @NotNull
    private String categoria;

    @NotNull(message="Inserire il titolo del post")
    private String titolo;

    private String cover;

    private String contenuto;

    private int tempoDiLettura;

    @NotNull(message="Inserire l'id dell'autore")
    private int autoreId;
}
