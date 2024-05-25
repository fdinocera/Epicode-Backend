package it.epicode.progetto.controller;

import it.epicode.progetto.DTO.DipendenteDto;
import it.epicode.progetto.DTO.DispositivoDto;
import it.epicode.progetto.exception.BadRequestException;
import it.epicode.progetto.exception.DipendenteNonTrovatoException;
import it.epicode.progetto.exception.DispositivoNonTrovatoException;
import it.epicode.progetto.model.Dipendente;
import it.epicode.progetto.model.Dispositivo;
import it.epicode.progetto.repository.DipendenteRepository;
import it.epicode.progetto.service.DipendenteService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/api/dipendenti")
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("/api/dipendenti")
    public List<Dipendente> getDipendenti() {
        return dipendenteService.getDipendenti();
    }

    @GetMapping("/api/dipendenti/{id}")
    public Optional<Dipendente> getDipendenteById(@PathVariable int id) {

        Optional<Dipendente> optionalDipendente = dipendenteService.getDipendenteById(id);

        if (optionalDipendente.isPresent()) {
            return Optional.of(optionalDipendente.get());
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato id=" + id);
        }
    }

    @PutMapping("/api/dipendenti/{id}")
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody DipendenteDto dipendenteDto) throws DipendenteNonTrovatoException {
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/api/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/api/dipendenti/{id}")
    public String patchFotoDipendente(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException {
        return dipendenteService.patchFotoDipendente(id, foto);
    }
}
