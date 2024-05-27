package it.epicode.esercizio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DipendenteDto {

    //@NotBlank(message="La username del dipendente non può essere vuota o solo spazi")
    @NotNull(message="La username del dipendente non può essere NULL")
    private String username;

    @NotBlank(message="Il nome del dipendente non può essere vuoto o solo spazi")
    private String nome;

    @NotBlank(message="Il cognome del dipendente non può essere vuoto o solo spazi")
    private String cognome;

    @NotBlank(message="La mail del dipendente non può essere vuota")
    private String email;
}
