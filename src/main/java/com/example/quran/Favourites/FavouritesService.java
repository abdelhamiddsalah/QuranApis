package com.example.quran.Favourites;

import com.example.quran.Ayat.AyaEntity;
import com.example.quran.Ayat.AyaRepo;
import com.example.quran.Surahs.SurahEntity;
import com.example.quran.Surahs.SurahRepo;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FavouritesService {

    @Autowired
    private FavouriteRepo favouriteRepo;
    @Autowired
    private SurahRepo surahRepo;
    @Autowired
    private AyaRepo ayaRepo;


    public FavouriteEntity addFavourite(Long surahId, Long ayaId) {
        SurahEntity surah = surahRepo.findById(surahId).orElseThrow(() -> new RuntimeException("Surah not found"));
        AyaEntity aya = ayaRepo.findById(ayaId).orElseThrow(() -> new RuntimeException("Aya not found"));

        FavouriteEntity favouritesentity = new FavouriteEntity();
        favouritesentity.setSurah(surah);
        favouritesentity.setAya(aya);

        if (favouriteRepo.existsBySurah_IdAndAya_AyaNumber(surah.getId(), aya.getAyaNumber())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Already exists in favourites");
        }


        return favouriteRepo.save(favouritesentity);
    }

    public List<FavouriteEntity> getFavourites() {
        List<FavouriteEntity> result = favouriteRepo.findAll();
        if (result.isEmpty()) {
            throw new RuntimeException("Favourites not found");
        }
        return result;

    }
}
