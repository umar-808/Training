/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringAuthenticationProject;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author kalsym
 */
@RestController
public class UserController {

    @Autowired
    UserRepository repo;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        repo.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repo.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User user1 = repo.findByUsername(user.getUsername());
        if (user1.getPassword().equals(user.getPassword())) {
            this.setAccessToken(generateRandomPassword(30));
            return new ResponseEntity<SuccessResponse>(new SuccessResponse(this.getAccessToken(), "bearer", 180, "create"), HttpStatus.OK);
        } else if (user.getPassword() == null || !user1.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<ErrorResponse>(new ErrorResponse("invalid_request", "Request was missing the 'password' parameter.", "See the full API docs at OAuth 2.0 Simplified"), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@RequestHeader("key") String key, @PathVariable Integer id) {
        if (key.equals(this.getAccessToken())) {
            User user = repo.findById(id).get();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
