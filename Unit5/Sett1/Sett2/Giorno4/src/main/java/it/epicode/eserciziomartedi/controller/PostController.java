package it.epicode.eserciziomartedi.controller;

import it.epicode.eserciziomartedi.DTO.PostDto;
import it.epicode.eserciziomartedi.exception.PostNonTrovatoException;
import it.epicode.eserciziomartedi.model.Post;
import it.epicode.eserciziomartedi.service.PostService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    public String creaPost(@RequestBody @Validated PostDto postDto, BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return postService.creaPost(postDto);
    }


    @GetMapping("/api/posts")
    public Page<Post> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return postService.getAllPosts(page, size, sortBy);
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable int id) {
        Optional<Post> postOptional = postService.getPostById(id);

        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    @PutMapping("/api/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@PathVariable int id, @RequestBody PostDto postDto) throws PostNonTrovatoException {
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }
}
