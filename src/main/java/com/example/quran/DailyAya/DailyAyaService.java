package com.example.quran.DailyAya;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyAyaService {

    private final DailyAyaRepo dailyAyaRepo;
    private int currentIndex = 0;

    @Scheduled(fixedRate = 86400000) // كل 24 ساعة
    public void updateDailyAya() {
        List<dailyAyaEntity> allAyat = dailyAyaRepo.findAll();

        if (allAyat.isEmpty()) {
            throw new IllegalStateException("لا توجد آيات في قاعدة البيانات");
        }

        dailyAyaEntity selectedAya = allAyat.get(currentIndex);

        dailyAyaEntity newAya = new dailyAyaEntity();
        newAya.setDailyAya(selectedAya.getDailyAya());
        newAya.setTime(new Timestamp(System.currentTimeMillis()));

        dailyAyaRepo.save(newAya);

        currentIndex = (currentIndex + 1) % allAyat.size();
    }
}