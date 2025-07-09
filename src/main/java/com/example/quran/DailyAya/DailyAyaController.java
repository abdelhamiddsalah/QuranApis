package com.example.quran.DailyAya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyAyaController {

    private final DailyAyaRepo dailyAyaRepo;

    public DailyAyaController(DailyAyaRepo dailyAyaRepo) {
        this.dailyAyaRepo = dailyAyaRepo;
    }

    @GetMapping("/dailyaya")
    public dailyAyaEntity getLatestAya() {
        return dailyAyaRepo.findAll()
                .stream()
                .sorted((a, b) -> b.getTime().compareTo(a.getTime())) // الأحدث أولًا
                .findFirst()
                .orElse(null);
    }
}
