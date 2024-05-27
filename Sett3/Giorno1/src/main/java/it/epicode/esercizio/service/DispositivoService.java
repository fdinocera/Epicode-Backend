package it.epicode.esercizio.service;

import it.epicode.esercizio.DTO.DispositivoDto;

import it.epicode.esercizio.enums.StatoDispositivo;
import it.epicode.esercizio.exception.*;

import it.epicode.esercizio.model.Dipendente;
import it.epicode.esercizio.model.Dispositivo;

import it.epicode.esercizio.repository.DipendenteRepository;
import it.epicode.esercizio.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public String saveDispositivo(DispositivoDto dispositivoDto) {

        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setNome(dispositivoDto.getNome());
        dispositivo.setTipo(dispositivoDto.getTipo());
        dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
        dispositivoRepository.save(dispositivo);
        return "Dispositivo salvato correttamente id=" + dispositivo.getId();
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getDispositivoById(int id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivo updateDispositivo(int id, DispositivoDto dispositivoDto) {

        Optional<Dispositivo> optionalDispositivo = getDispositivoById(id);

        if (optionalDispositivo.isPresent()) {
            Dispositivo dispositivo = optionalDispositivo.get();
            dispositivo.setNome(dispositivoDto.getNome());
            dispositivo.setTipo(dispositivoDto.getTipo());
            dispositivo.setStatoDispositivo(dispositivoDto.getStatoDispositivo());
            dispositivoRepository.save(dispositivo);
            return dispositivo;
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato");
        }
    }

    public String deleteDispositivo(int id) {

        Optional<Dispositivo> optionalDispositivo = getDispositivoById(id);

        if (optionalDispositivo.isPresent()) {
            dispositivoRepository.delete(optionalDispositivo.get());
            return "Dispositivo cancellato correttamente id=" + id;
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato");
        }
    }

    public String patchAssegnaDispositivo(int idDipendente, int idDispositivo){

        Optional<Dispositivo> optionalDispositivo = dispositivoRepository.findById(idDispositivo);
        if (optionalDispositivo.isPresent()) {

            Dispositivo dispositivo = optionalDispositivo.get();

            if (dispositivo.getStatoDispositivo() == StatoDispositivo.DISPONIBILE) {

                Optional<Dipendente> optionalDipendente = dipendenteRepository.findById(idDipendente);
                if (optionalDipendente.isPresent()) {
                    Dipendente dipendente = optionalDipendente.get();
                    dispositivo.setDipendente(dipendente);
                    dispositivo.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
                    dispositivoRepository.save(dispositivo);
                } else {
                    throw new DipendenteNonTrovatoException("Dipendente non trovato");
                }
            } else {
                throw new RuntimeException("Il dispositivo con id=" + idDispositivo + " non è DISPONIBILE per l'assegnazione");
            }
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato id=" + idDispositivo);
        }
        return "Dispositivo con id=" + idDispositivo + " assegnato al dipendente con id=" + idDipendente;
    }
}
