package it.epicode.eserciziomartedi.repository;

import it.epicode.eserciziomartedi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
