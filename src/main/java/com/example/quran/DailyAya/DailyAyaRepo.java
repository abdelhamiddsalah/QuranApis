package com.example.quran.DailyAya;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyAyaRepo extends JpaRepository<dailyAyaEntity,Long> {
    @Override
    Optional<dailyAyaEntity> findById(Long id);
}
