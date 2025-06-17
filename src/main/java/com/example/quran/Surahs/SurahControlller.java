package com.example.quran.Surahs;

import com.example.quran.Ayat.AyaDto;
import com.example.quran.Ayat.AyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurahControlller {

    @Autowired
    private SurahService surahService;

    @Autowired
    private AyaService ayaService;

    @GetMapping("/surahs")
    public List<SurahDto> getAllSurahs() {
        return surahService.getAllSurahs();
    }

    // ✅ تعديل هنا لإرجاع السورة + آياتها
    @GetMapping("/surahs/{id}/ayata")
    public SurahWithAyatDto getSurahWithAyat(@PathVariable Long id) {
        SurahDto surahDto = surahService.getSurahById(id);
        List<AyaDto> ayat = ayaService.getAyatBySurahId(id);
        return new SurahWithAyatDto(surahDto, ayat);
    }
}
