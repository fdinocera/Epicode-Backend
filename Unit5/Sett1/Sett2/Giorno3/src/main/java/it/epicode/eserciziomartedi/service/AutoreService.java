package it.epicode.eserciziomartedi.service;

import it.epicode.eserciziomartedi.DTO.AutoreDto;
import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;

import it.epicode.eserciziomartedi.model.Autore;
import it.epicode.eserciziomartedi.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    AutoreRepository autoreRepository;

    private List<Autore> autori = new ArrayList<>();

    public List<Autore> getAllAutori() {
        return autoreRepository.findAll();
    }

    public String creaAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        //autori.add(autore);

        autoreRepository.save(autore);
        return "Autore creato con successo id=" + autore.getId();
    }

    public Optional< Autore> getAutoreById(int id) {

//        Optional<Autore> autore = autori.stream().filter(aut -> aut.getId() == id).findFirst();
//
//        if (autore.isPresent()) {
//            return autore.get();
//        } else {
//            throw new RuntimeException();
//        }
        return autoreRepository.findById(id);
    }


    public Autore updateAutore(int id, Autore autoreUpd) throws AutoreNonTrovatoException {

        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpd.getNome());
            autore.setCognome(autoreUpd.getCognome());
            autore.setDataDiNascita(autoreUpd.getDataDiNascita());
            autore.setEmail(autoreUpd.getEmail());
            autore.setAvatar(autoreUpd.getAvatar());
            return autore;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            autori.remove(autoreOpt.get());
            return "Autore cancellato";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }
}
