package com.example.quran.Favourites;

import com.example.quran.Auth.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteRepo extends JpaRepository<FavouriteEntity, Long> {

    // ✅ لجلب المفضلات الخاصة بمستخدم محدد
    List<FavouriteEntity> findByUser(AppUserEntity user);

    // ✅ لفحص هل مفضلة موجودة لهذا المستخدم بالفعل
    boolean existsByUserAndSurah_IdAndAya_AyaNumber(AppUserEntity user, Long surahId, int ayaNumber);
}
