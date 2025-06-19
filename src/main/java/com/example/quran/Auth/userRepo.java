package com.example.quran.Auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<AppUserEntity,Long> {
    Optional<AppUserEntity> findByEmail(String email);

}
