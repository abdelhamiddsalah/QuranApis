package com.example.quran.Auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // لو API فقط
                .authorizeHttpRequests()
                .requestMatchers("/auth/**").permitAll() // السماح بتسجيل الدخول والتسجيل
                .anyRequest().authenticated()            // الباقي لازم توكن
                .and()
                .httpBasic(); // أو استخدم formLogin() أو JWT

        return http.build();
    }
}
