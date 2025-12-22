package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * REGISTER USER
     * URL: POST /auth/register
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /**
     * LOGIN USER (simple validation for review)
     * URL: POST /auth/login
     */
    @PostMapping("/login")
    public String login(@RequestBody User request) {

        User user = userService.findByEmail(request.getEmail());

        if (!user.getPassword().equals(request.getPassword())) {
            return "Invalid password";
        }

        return "Login successful for user: " + user.getEmail();
    }
}
