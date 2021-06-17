package com.ksga.springminiproject002.controller.rest;

import com.ksga.springminiproject002.model.Post;
import com.ksga.springminiproject002.payload.mapper.PostMapper;
import com.ksga.springminiproject002.payload.request.PostRequest;
import com.ksga.springminiproject002.service.PostService;
import com.ksga.springminiproject002.utilities.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class PostRestController {
    private final PostService postService;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPosts (@RequestParam int page, @RequestParam int limit) {
        Post post = new Post();
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setLimit(limit);
        Map<String, Object> response = new HashMap<>();
        response.put("data",postService.findAll(paging));
        response.put("pagination",paging);
        response.put("message","successfully fetched");
        response.put("status", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> insertArticle(@RequestBody PostRequest post){
        Map<String, Object> response = new HashMap<>();

        response.put("message","successfully create");
        response.put("data",postService.insert(post));
        response.put("status", HttpStatus.CREATED);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public Map<String, Object> updatePost () {
        Post posts = new Post();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();


        return response;
    }
    @DeleteMapping("/{id}")
    public Map<String, Object> deletePost () {
        Post posts = new Post();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();


        return response;
    }
}
