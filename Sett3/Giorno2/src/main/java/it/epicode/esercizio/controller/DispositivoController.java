package it.epicode.esercizio.controller;

import it.epicode.esercizio.DTO.DispositivoDto;

import it.epicode.esercizio.exception.BadRequestException;
import it.epicode.esercizio.exception.DispositivoNonTrovatoException;

import it.epicode.esercizio.model.Dispositivo;

import it.epicode.esercizio.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/api/dispositivi")
    public String saveDispositivo(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws BadRequestException {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return dispositivoService.saveDispositivo(dispositivoDto);
    }

    @GetMapping("/api/dispositivi")
    public List<Dispositivo> getDispositivi() {
        return dispositivoService.getDispositivi();
    }

    @GetMapping("/api/dispositivi/{id}")
    public Dispositivo getDispositivoById(@PathVariable int id) {

        Optional<Dispositivo> optionalDispositivo = dispositivoService.getDispositivoById(id);

        if (optionalDispositivo.isPresent()) {
            return optionalDispositivo.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato id=" + id);
        }
    }

    @PutMapping("/api/dispositivi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dispositivo updateDispositivo(@PathVariable int id, @RequestBody DispositivoDto dispositivoDto) throws DispositivoNonTrovatoException {
        return dispositivoService.updateDispositivo(id, dispositivoDto);
    }

    @DeleteMapping("/api/dispositivi/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteDispositivo(@PathVariable int id) {

        return dispositivoService.deleteDispositivo(id);
    }

    @PatchMapping("/api/dispositivi/{idDipendente}/{idDispositivo}")
    public String patchDispositivo(@PathVariable int idDipendente, @PathVariable int idDispositivo){
        return dispositivoService.patchAssegnaDispositivo(idDipendente,idDispositivo);
    }
}
