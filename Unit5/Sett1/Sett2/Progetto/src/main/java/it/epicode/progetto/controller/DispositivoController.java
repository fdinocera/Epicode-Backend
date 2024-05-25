package it.epicode.progetto.controller;

import it.epicode.progetto.DTO.DispositivoDto;

import it.epicode.progetto.exception.BadRequestException;
import it.epicode.progetto.exception.DispositivoNonTrovatoException;

import it.epicode.progetto.model.Dispositivo;

import it.epicode.progetto.service.DispositivoService;
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
    public String deleteDispositivo(@PathVariable int id) {
        return dispositivoService.deleteDispositivo(id);
    }

//    @PatchMapping("/api/dipendenti/{id}")
//    public String patchFotoDipendente(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException {
//        return dipendenteService.patchFotoDipendente(id, foto);
//    }

    @PatchMapping("/api/dispositivi/{idDipendente}/{idDispositivo}")
    public String patchDispositivo(@PathVariable int idDipendente, @PathVariable int idDispositivo){
        return dispositivoService.patchAssegnaDispositivo(idDipendente,idDispositivo);
    }
}
