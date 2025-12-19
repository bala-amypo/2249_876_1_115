// package com.example.demo.controller;

// import com.example.demo.dto.*;
// // import com.example.demo.entity.User
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.*;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final AuthenticationManager authenticationManager;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.authenticationManager = authenticationManager;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
//         User user = new User(request.getFullName(), request.getEmail(), request.getPassword(), "MONITOR");
//         User savedUser = userService.registerUser(user);
//         String token = jwtUtil.generateToken(savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
//         return ResponseEntity.ok(new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole()));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
//         try {
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//         } catch (BadCredentialsException e) {
//             throw new IllegalArgumentException("Invalid email or password");
//         }

//         User user = userService.findByEmail(request.getEmail());
//         String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
//         return ResponseEntity.ok(new AuthResponse(token, user.getId(), user.getEmail(), user.getRole()));
//     }
// }
