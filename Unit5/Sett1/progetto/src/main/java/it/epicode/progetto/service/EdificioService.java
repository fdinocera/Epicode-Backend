package it.epicode.progetto.service;

import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repositories.EdificioRepository;
import it.epicode.progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio creaEdificio(Edificio edificio){
        return edificioRepository.save(edificio);
    }

    public Edificio getEdificio(long id){
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getEdifici(){
        return edificioRepository.findAll();
    }
}
