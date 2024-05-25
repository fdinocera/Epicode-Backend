package it.epicode.progetto.service;

import com.cloudinary.Cloudinary;
import it.epicode.progetto.DTO.DipendenteDto;
import it.epicode.progetto.DTO.DispositivoDto;
import it.epicode.progetto.enums.StatoDispositivo;

import it.epicode.progetto.exception.DipendenteNonTrovatoException;
import it.epicode.progetto.exception.DispositivoNonTrovatoException;

import it.epicode.progetto.model.Dipendente;
import it.epicode.progetto.model.Dispositivo;
import it.epicode.progetto.repository.DipendenteRepository;
import it.epicode.progetto.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    public String saveDipendente(DipendenteDto dipendenteDto) {

        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setUsername(dipendenteDto.getUsername());

        dipendenteRepository.save(dipendente);
        return "Dipendente salvato correttamente id=" + dipendente.getId();
    }

    public List<Dipendente> getDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> getDipendenteById(int id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {

        Optional<Dipendente> optionalDipendente = getDipendenteById(id);

        if (optionalDipendente.isPresent()) {
            Dipendente dipendente = optionalDipendente.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendenteRepository.save(dipendente);
            return dipendente;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato");
        }
    }

    public String deleteDipendente(int id) {

        Optional<Dipendente> optionalDipendente = getDipendenteById(id);

        if (optionalDipendente.isPresent()) {
            dipendenteRepository.delete(optionalDipendente.get());
            return "Dipendente cancellato correttamente id=" + id;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato");
        }
    }

    public String patchFotoDipendente(int id, MultipartFile foto) throws IOException {

        Optional<Dipendente> optionalDipendente = getDipendenteById(id);

        if (optionalDipendente.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = optionalDipendente.get();
            dipendente.setFoto(url);
            dipendenteRepository.save(dipendente);
            return "Aggiornata foto dipendente id=" + id;
        } else {
            throw new DipendenteNonTrovatoException("");
        }
    }
}
