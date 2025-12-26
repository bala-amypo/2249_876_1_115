@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials"));

        return new AuthResponse(user.getId(), user.getEmail(), "TOKEN");
    }
}
