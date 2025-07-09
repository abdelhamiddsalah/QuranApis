package com.example.quran.Auth;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "app_user_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String confirmPassword;
    private String theme ;
    private String role;

    // ✅ Authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> role); // لازم تبدأ بـ ROLE_
    }

    // ✅ Username for Spring
    @Override
    public String getUsername() {
        return email; // علشان Spring Security
    }

    // Getter عادي عشان أستخدم الـ username في أي مكان تاني
    public String getDisplayName() {
        return username;
    }



    // ✅ Account checks
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
