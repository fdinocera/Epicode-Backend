package it.epicode.eserciziomartedi.controller;

import it.epicode.eserciziomartedi.exception.PostNonTrovatoException;
import it.epicode.eserciziomartedi.model.Post;
import it.epicode.eserciziomartedi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    public String creaPost(@RequestBody Post post){
        return postService.creaPost(post);
    }

    @GetMapping("/api/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable int id){
        Optional <Post> postOptional = postService.getPost(id);

        if (postOptional.isPresent()){
            return postOptional.get();
        }else{
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable  int id, @RequestBody Post post){
        return   postService.updatePost(id, post);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }
}
