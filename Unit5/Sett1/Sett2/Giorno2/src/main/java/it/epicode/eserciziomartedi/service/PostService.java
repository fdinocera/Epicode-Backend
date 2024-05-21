package it.epicode.eserciziomartedi.service;

import it.epicode.eserciziomartedi.model.Post;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getAllPosts(){
        return posts;
    }

    public String creaPost(Post post){
        posts.add(post);
        return "Post creato con successo";
    }
}
