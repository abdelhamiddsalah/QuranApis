package com.example.quran.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final userRepo userrepo;
    private final PasswordConfig passwordConfig;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String signup(String username, String password, String confirmPassword, String email) {

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if (userrepo.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        AppUserEntity user = new AppUserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordConfig.passwordEncoder().encode(password));
        user.setConfirmPassword(passwordConfig.passwordEncoder().encode(confirmPassword));
        user.setRole("ROLE_USER");
        user.setTheme("Light");

        userrepo.save(user);

        return jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRole()))
                ),
                user.getUserId() // ✅ أضف الـ id هنا
        );
    }

    public String login(String email, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.OK, "Invalid email or password");
        }

        AppUserEntity user = userrepo.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.OK, "User not found"));

        return jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority(user.getRole()))
                ),
                user.getUserId() // ✅ أضف الـ id هنا
        );
    }

    AppUserEntity findByid(Long id) {
        return userrepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.OK, "User Not Found"));
    }


}
