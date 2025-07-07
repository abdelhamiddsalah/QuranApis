package com.example.quran.Favourites;

import com.example.quran.Auth.AppUserEntity;
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


    public FavouriteEntity addFavourite(Long surahId, Long ayaId, AppUserEntity user) {
        SurahEntity surah = surahRepo.findById(surahId)
                .orElseThrow(() -> new RuntimeException("Surah not found"));

        AyaEntity aya = ayaRepo.findById(ayaId)
                .orElseThrow(() -> new RuntimeException("Aya not found"));

        // ✅ استخدم الدالة الجديدة للتحقق من الوجود للمستخدم الحالي
        if (favouriteRepo.existsByUserAndSurah_IdAndAya_AyaNumber(user, surah.getId(), aya.getAyaNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Already exists in favourites");
        }

        FavouriteEntity favourite = new FavouriteEntity();
        favourite.setSurah(surah);
        favourite.setAya(aya);
        favourite.setUser(user);

        return favouriteRepo.save(favourite);
    }



    public List<FavouriteEntity> getFavourites(AppUserEntity user) {
        List<FavouriteEntity> result = favouriteRepo.findByUser(user);
        if (result.isEmpty()) {
            throw new RuntimeException("No favourites found for this user");
        }
        return result;
    }


    public Boolean IsFavourite(Long surahId, Long ayaId, AppUserEntity user) {
        SurahEntity surah = surahRepo.findById(surahId)
                .orElseThrow(() -> new RuntimeException("Surah not found"));
        AyaEntity aya = ayaRepo.findById(ayaId)
                .orElseThrow(() -> new RuntimeException("Aya not found"));

        return favouriteRepo.existsByUserAndSurah_IdAndAya_AyaNumber(user, surah.getId(), aya.getAyaNumber());
    }

}
