package it.epicode.progetto.service;

import it.epicode.progetto.entities.Postazione;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente creaUtente(Utente utente){
        return utenteRepository.save(utente);
    }

    public Utente getUtente(long id){
        return utenteRepository.findById(id).get();
    }

    public List<Utente> getUtenti(){
        return utenteRepository.findAll();
    }



}
