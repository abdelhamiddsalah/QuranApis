package com.example.quran.Auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "confirm_password")
    private String confirmPassword;
    @Column(name = "theme")
    private String theme;
    @Column(name = "role")
    private String role;
}
