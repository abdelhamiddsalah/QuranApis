package com.example.quran.Favourites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepo extends JpaRepository<FavouriteEntity, Long> {
    boolean existsBySurah_IdAndAya_AyaNumber(Long surahId, int ayaNumber);
}

