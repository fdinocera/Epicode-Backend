package it.epicode.eserciziomartedi.controller;

import it.epicode.eserciziomartedi.DTO.AutoreDto;
import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;
import it.epicode.eserciziomartedi.exception.BadRequesException;
import it.epicode.eserciziomartedi.model.Autore;
import it.epicode.eserciziomartedi.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AutoreController {

    @Autowired
    AutoreService autoreService;

    @PostMapping("/api/autori")
    public String creaAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequesException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
            //throw new BadRequesException("Autore non creato");
        }
        return autoreService.creaAutore(autoreDto);
    }

    @GetMapping("/api/autori")
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutore(@PathVariable int id) throws AutoreNonTrovatoException {

        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);

        if (autoreOptional.isPresent()) {
            return autoreOptional.get();
        } else {
            throw new AutoreNonTrovatoException("autore non trovato id=" + id);
        }
    }

    @PutMapping("/api/autori/{id}")
    public Autore putAutore(@PathVariable int id, @RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequesException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.deleteAutore(id);
    }

    @PatchMapping("/api/autori/{matricola}")
    public String patchFotoAutore(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException {

        return autoreService.patchFotoAutore(id, foto);
    }
}
