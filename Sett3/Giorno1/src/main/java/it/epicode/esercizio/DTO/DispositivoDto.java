package it.epicode.esercizio.DTO;

import it.epicode.esercizio.enums.StatoDispositivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoDto {

    @NotBlank(message = "Il nome del dispositivo non può essere vuoto o solo spazi")
    String nome;

    @NotNull(message ="Il tipo di dispositivo non può essere NULL")
    String tipo;

    StatoDispositivo statoDispositivo;
}