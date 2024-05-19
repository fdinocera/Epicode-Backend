package it.epicode.progetto.service;


import it.epicode.progetto.ENUMS.TipoPostazione;
import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.entities.Postazione;
import it.epicode.progetto.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione creaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public Postazione getPostazione(long id) {
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> getPostazioni() {
        return postazioneRepository.findAll();
    }

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoPostazioneAndCitta(tipoPostazione, citta);
    }

}
