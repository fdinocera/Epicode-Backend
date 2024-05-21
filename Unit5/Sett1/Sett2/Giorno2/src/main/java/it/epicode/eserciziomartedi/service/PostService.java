package it.epicode.eserciziomartedi.service;

import it.epicode.eserciziomartedi.exception.PostNonTrovatoException;
import it.epicode.eserciziomartedi.model.Post;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getAllPosts() {
        return posts;
    }

    public String creaPost(Post post) {
        posts.add(post);
        return "Post creato con successo id=" + post.getId();
    }

    public Optional<Post> getPost(int id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public Post updatePost(int id, Post postUpd) {
        Optional<Post> postOptional = getPost(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setCategoria(postUpd.getCategoria());
            post.setContenuto(postUpd.getContenuto());
            post.setTitolo(postUpd.getTitolo());
            post.setTempoDiLettura(postUpd.getTempoDiLettura());
            return post;
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    public String deletePost(int id) {
        Optional<Post> postOptional = getPost(id);

        if (postOptional.isPresent()) {
            posts.remove(postOptional.get());
            return "Post cancellato id=" + id;
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }
}



