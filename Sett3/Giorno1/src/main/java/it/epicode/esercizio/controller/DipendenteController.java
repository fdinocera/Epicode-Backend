package it.epicode.esercizio.controller;

import it.epicode.esercizio.DTO.DipendenteDto;
import it.epicode.esercizio.exception.BadRequestException;
import it.epicode.esercizio.exception.DipendenteNonTrovatoException;
import it.epicode.esercizio.model.Dipendente;
import it.epicode.esercizio.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
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
