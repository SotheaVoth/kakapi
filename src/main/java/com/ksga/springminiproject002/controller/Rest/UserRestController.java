package com.ksga.springminiproject002.controller.Rest;

import com.ksga.springminiproject002.model.Posts;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    @GetMapping
    public Map<String, Object> getAllUsers () {
        Posts posts = new Posts();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();
        response.put("status", 200);
        response.put("message", "You success");
        response.put("success", true);
        response.put("payload", posts);

        return response;
    }
    @PostMapping
    public Map<String, Object> createUser () {
        Posts posts = new Posts();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();


        return response;
    }
    @PutMapping
    public Map<String, Object> updateUser () {
        Posts posts = new Posts();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();


        return response;
    }
    @DeleteMapping
    public Map<String, Object> deleteUser () {
        Posts posts = new Posts();
        posts.setCaption("This is caption test");

        Map<String, Object> response = new HashMap();


        return response;
    }
}
