package com.example.quran.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class AyaJsonLoader {

    private final SearchRepo ayaSearchRepository;

    public AyaJsonLoader(SearchRepo repository) {
        this.ayaSearchRepository = repository;
    }

    public void loadFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("data/quran.json").getInputStream();

            // قراءة الملف كمصفوفة من السور
            List<SurahDTO> surahs = mapper.readValue(inputStream, new TypeReference<List<SurahDTO>>() {});

            for (SurahDTO surah : surahs) {
                for (VerseDTO verse : surah.getVerses()) {
                    AyaSearchEntity aya = new AyaSearchEntity();
                    aya.setAyaNumber(verse.getId());
                    aya.setAyaText(verse.getText()); // بالتشكيل
                    aya.setAyaTextStripped(ArabicNormalizer.removeTashkeel(verse.getText())); // بدون تشكيل
                    aya.setSurahName(surah.getName());
                    ayaSearchRepository.save(aya);
                }
                System.out.println("تم استيراد الآيات من السورة: " + surah.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
