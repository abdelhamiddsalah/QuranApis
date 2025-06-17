package com.example.quran.Ayat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AyaRepo extends JpaRepository<AyaEntity, Long> {
    // استخدم العلاقة الجديدة
    List<AyaEntity> findBySurah_Id(Long id);
}
