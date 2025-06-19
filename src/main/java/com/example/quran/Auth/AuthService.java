package com.example.quran.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final userRepo userrepo;
    private final PasswordConfig passwordConfig;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String signup(String username, String password, String confirmPassword, String email) {

        // تأكد من تطابق كلمة السر
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        // تأكد من عدم تكرار المستخدم
        if (userrepo.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        // إنشاء كيان المستخدم
        AppUserEntity user = new AppUserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordConfig.passwordEncoder().encode(password));
        user.setConfirmPassword(null); // مش محتاجين نخزنها
        user.setRole("ROLE_USER"); // لازم تضيف الحقل ده في الـ entity

        userrepo.save(user);

        // توليد التوكن
        return jwtService.generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        ));

    }
    public String login(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        AppUserEntity user = userrepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return jwtService.generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        ));
    }

}
