package it.epicode.progetto.repositories;

import it.epicode.progetto.entities.Prenotazione;
import it.epicode.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
