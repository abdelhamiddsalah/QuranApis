package com.example.quran.Surahs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurahRepo extends JpaRepository<SurahEntity,Long> {
}
