package it.epicode.eserciziomartedi.service;

import it.epicode.eserciziomartedi.DTO.PostDto;
import it.epicode.eserciziomartedi.exception.AutoreNonTrovatoException;
import it.epicode.eserciziomartedi.exception.PostNonTrovatoException;
import it.epicode.eserciziomartedi.model.Autore;
import it.epicode.eserciziomartedi.model.Post;
import it.epicode.eserciziomartedi.repository.AutoreRepository;
import it.epicode.eserciziomartedi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AutoreRepository autoreRepository;

    private List<Post> posts = new ArrayList<>();


    public Page<Post> getAllPosts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return postRepository.findAll(pageable);
    }

    public String creaPost(PostDto postDto) {
        Post post = new Post();
        post.setTitolo(postDto.getTitolo());
        post.setCategoria(postDto.getCategoria());
        post.setContenuto(postDto.getContenuto());
        post.setTempoDiLettura(postDto.getTempoDiLettura());
        post.setCover(postDto.getCover());

        Optional<Autore> optionalAutore = autoreRepository.findById(postDto.getAutoreId());

        if (optionalAutore.isPresent()) {
            Autore autore = optionalAutore.get();
            post.setAutore(autore);
            postRepository.save(post);
            return "Post salvato correttamente id=" + post.getId();
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato id=" + postDto.getAutoreId());
        }
    }

    public Optional<Post> getPostById(int id) {
        return postRepository.findById(id);
    }

    public Post updatePost(int id, PostDto postDto) {
        Optional<Post> postOptional = getPostById(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setCategoria(postDto.getCategoria());
            post.setContenuto(postDto.getContenuto());
            post.setTitolo(postDto.getTitolo());
            post.setTempoDiLettura(postDto.getTempoDiLettura());

            Optional<Autore> optionalAutore = autoreRepository.findById(postDto.getAutoreId());

            if (optionalAutore.isPresent()) {
                Autore autore = optionalAutore.get();
                post.setAutore(autore);
                postRepository.save(post);
                return post;
            } else {
                throw new AutoreNonTrovatoException("Autore non trovato");
            }
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    public String deletePost(int id) {
        Optional<Post> postOptional = getPostById(id);

        if (postOptional.isPresent()) {
            posts.remove(postOptional.get());
            return "Post cancellato id=" + id;
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }
}



