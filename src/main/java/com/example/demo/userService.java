package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;

@Service
public class userService {
    private final myRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public userService(myRepository repo) {
        this.repo = repo;
    }
    public users regUser(String username,String originalPassword,String email){
        if(repo.findByUsername(username).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        String encryptpassword = encoder.encode(originalPassword);
        users user =new users();
        user.setUsername(username);
        user.setPassword(encryptpassword);
        user.setEmail(email);
        return repo.save(user);
    }
    public boolean login(String username, String rawPassword){
        return repo.findByUsername(username).map(users -> encoder.matches(rawPassword, users.getPassword())).orElse(false);
    }
}
