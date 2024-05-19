package it.epicode.progetto.repositories;

import it.epicode.progetto.ENUMS.TipoPostazione;
import it.epicode.progetto.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.citta = :citta")
    List<Postazione> findByTipoPostazioneAndCitta(@Param("tipo") TipoPostazione tipo, @Param("citta") String citta);
}
