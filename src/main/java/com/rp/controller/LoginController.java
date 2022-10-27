package com.rp.controller;

import com.rp.domain.model.User;
import com.rp.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<User> login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body(null);
        }
        user.setPassword("******");
        return ResponseEntity.ok(user);
    }

}
