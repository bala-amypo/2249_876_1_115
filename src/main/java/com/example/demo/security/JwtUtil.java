package com.example.demo.security;

public class JwtUtil {

    public JwtUtil() {}

    public String generateToken(Long userId, String email, String role) {
        return "dummy-token";
    }

    public String extractEmail(String token) {
        return null;
    }

    public String extractRole(String token) {
        return null;
    }

    public Long extractUserId(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return true;
    }
}
