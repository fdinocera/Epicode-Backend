package it.epicode.eserciziomartedi.repository;

import it.epicode.eserciziomartedi.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
