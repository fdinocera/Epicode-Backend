package it.epicode.progetto.service;

import it.epicode.progetto.entities.Edificio;
import it.epicode.progetto.entities.Postazione;
import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.entities.Utente;
import it.epicode.progetto.repositories.EdificioRepository;
import it.epicode.progetto.repositories.PostazioneRepository;
import it.epicode.progetto.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;



    public Prenotazione getPrenotazione(long id) {
        return prenotazioneRepository.findById(id).get();
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void creaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

//    public Prenotazione creaPrenotazione(Utente utente, Long postazioneId, LocalDate data){
//
//        Postazione postazione = postazioneRepository.findById(postazioneId)
//                    .orElseThrow(() -> new RuntimeException("Postazione non trovata"));
//
////        if (prenotazioneRepository.existsByPostazioneAndData(postazioneRepository.findById(postazioneId).orElse(null), data)){
////            throw new RuntimeException("Postazione già prenotata per questa data");
////        }
////
////        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
////            throw new RuntimeException("Postazione già prenotata per questa data");
////        }
////
////        if (!prenotazioneRepository.findByUtenteAndData(utente,data).isEmpty()){
////            throw new RuntimeException("L'utente ha già una prenotazione per questa data");
////        }
//
////        Prenotazione prenotazione = new Prenotazione();
////        prenotazione.setUtente(utente);
////        prenotazione.setPostazione(postazioneRepository.findById(postazioneId).orElse(null));
////        prenotazione.setDataPrenotazione(data);
//
//          return prenotazioneRepository.save(prenotazione);
//    }



    public List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data) {
        return prenotazioneRepository.findByUtenteAndData(utente, data);
    }

    public boolean existsPrenotazioneByUtenteIdAndData(Long utenteId, LocalDate data) {
        if (prenotazioneRepository.existsPrenotazioneByUtenteIdAndData(utenteId, data) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
