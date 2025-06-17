package com.example.quran.Surahs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurashLoader implements CommandLineRunner {

    private final SurahRepo surahrepo;
    private final SurahMapper surahMapper;

    public SurashLoader(SurahRepo surahrepo, SurahMapper surahMapper) {
        this.surahrepo = surahrepo;
        this.surahMapper = surahMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        // تحميل الملف JSON من resources/data/full_surahs.json
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data/full_surahs.json").getInputStream();

        // قراءة البيانات وتحويلها إلى List<SurahDto>
        List<SurahDto> dtos = mapper.readValue(inputStream, new TypeReference<List<SurahDto>>() {});

        // تحويلها إلى List<SurahEntity>
        List<SurahEntity> entities = dtos.stream()
                .map(surahMapper::toEntity)
                .collect(Collectors.toList());

        // حفظ البيانات في قاعدة البيانات
        surahrepo.saveAll(entities);


        System.out.println("تم تحميل السور بنجاح إلى قاعدة البيانات.");
    }
}
