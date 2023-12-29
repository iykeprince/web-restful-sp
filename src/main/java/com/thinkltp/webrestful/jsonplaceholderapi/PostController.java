package com.thinkltp.webrestful.jsonplaceholderapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Map<String,Object>> getAllPosts() {
        return this.postService.getPosts();
    }

    @GetMapping("{id}")
    public Map<String, Object> getPostById(@PathVariable("id") int id) {
        return this.postService.getPostById(id);
    }

    @PostMapping
    public Map<String, Object> createPost(@RequestBody Map<String, Object> payload) {
        return this.postService.createPost(payload);
    }

    @PutMapping("{id}")
    public Map<String, Object> updatePost(@RequestBody Map<String, Object> payload, @PathVariable("id") int id) {
        return postService.updatePost(payload, id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deletePost(@PathVariable("id") int id) {
        return postService.deletePost(id);
    }
}
