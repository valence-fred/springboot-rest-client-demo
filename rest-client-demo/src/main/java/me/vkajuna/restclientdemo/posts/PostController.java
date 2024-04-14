package me.vkajuna.restclientdemo.posts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        return ResponseEntity.ok(postService.create(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable("id") Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.update(id,post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
