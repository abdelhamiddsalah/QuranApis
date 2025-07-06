package com.example.quran.Favourites;

public class FavouritesRequest {
    private Long surahId;
    private Long ayaId;

    // Getters and Setters
    public Long getSurahId() {
        return surahId;
    }

    public void setSurahId(Long surahId) {
        this.surahId = surahId;
    }

    public Long getAyaId() {
        return ayaId;
    }

    public void setAyaId(Long ayaId) {
        this.ayaId = ayaId;
    }
}
