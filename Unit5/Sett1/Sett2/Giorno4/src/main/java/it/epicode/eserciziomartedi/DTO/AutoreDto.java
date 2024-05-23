package it.epicode.eserciziomartedi.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {

    @NotNull(message="Inserire il nome dell'autore")
    private String nome;

    @NotNull(message="Inserire il cognome dell'autore")
    private String cognome;

    @Email
    @NotNull
    private String email;

    private LocalDate dataDiNascita;
}
