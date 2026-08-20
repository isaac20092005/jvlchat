package com.jvlcode.jvlchat.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jvlcode.jvlchat.entity.User;
import com.jvlcode.jvlchat.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String uname,
            @RequestParam String phone) {

        Optional<User> user =
                userRepository.findByUnameAndPhone(uname, phone);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.status(401)
                .body("Invalid username or phone");
    }
}