package it.epicode.eserciziomartedi.controller;

import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;
import it.epicode.eserciziomartedi.model.Autore;
import it.epicode.eserciziomartedi.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {

    @Autowired
    AutoreService autoreService;

    @GetMapping("/api/autori")
    List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @PostMapping("/api/autori")
    public String creaAutore(@RequestBody Autore autore){
        return autoreService.creaAutore(autore);
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutore(@PathVariable int id){
        return autoreService.getAutore(id);
    }

    @PutMapping("/api/autori/{id}")
    public Autore putAutore(@PathVariable int id, @RequestBody Autore autore) throws AutoreNonTrovatoException {
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException{
        return autoreService.deleteAutore(id);
    }
}
