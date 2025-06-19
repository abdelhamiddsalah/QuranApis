package com.example.quran.Auth;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class userDto {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String confirmPassword;
}
