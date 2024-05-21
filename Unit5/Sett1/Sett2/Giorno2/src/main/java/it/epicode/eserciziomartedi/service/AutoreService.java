package it.epicode.eserciziomartedi.service;

import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;

import it.epicode.eserciziomartedi.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();

    public List<Autore> getAllAutori() {
        return autori;
    }


    public String creaAutore(Autore autore) {
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        autori.add(autore);
        return "autore creato con successo id=" + autore.getId();
    }

    public Autore getAutore(int id) {

        Optional<Autore> autore = autori.stream().filter(aut -> aut.getId() == id).findFirst();

        if (autore.isPresent()) {
            return autore.get();
        } else {
            throw new RuntimeException();
        }
    }


    public Autore updateAutore(int id, Autore autoreUpd) throws AutoreNonTrovatoException {

        Optional<Autore> autoreOpt = Optional.ofNullable(getAutore(id));

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
        Optional<Autore> autoreOpt = Optional.ofNullable(getAutore(id));
        if (autoreOpt.isPresent()) {
            autori.remove(autoreOpt.get());
            return "Autore cancellato";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }
}
