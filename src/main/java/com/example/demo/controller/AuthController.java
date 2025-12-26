package com.example.demo.controller;

import com.example.demo.dtoDTO.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {

        Optional<User> existing =
                userRepository.findByEmail(request.getEmail());

        if (existing.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("Email already exists"));
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain for now
        user.setRole("USER");

        userRepository.save(user);

        return ResponseEntity.ok(
                new AuthResponse("User registered successfully"));
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        Optional<User> userOpt =
                userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("Invalid email or password"));
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("Invalid email or password"));
        }

        return ResponseEntity.ok(
                new AuthResponse("Login successful"));
    }
}
