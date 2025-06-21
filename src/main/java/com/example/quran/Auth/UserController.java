package com.example.quran.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        String token = authService.signup(
                request.getUsername(),
                request.getPassword(),
                request.getConfirmPassword(),
                request.getEmail()
        );
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.login(
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @GetMapping("/profile/{id}")
    public AppUserEntity getUser(@PathVariable Long id) {
        return authService.findByid(id);
    }

}
