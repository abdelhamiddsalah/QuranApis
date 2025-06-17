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
        if (surahrepo.count() > 0) {
            System.out.println("السور موجودة بالفعل في قاعدة البيانات، لن يتم التحميل مرة أخرى.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("data/full_surahs.json").getInputStream();

        List<SurahDto> dtos = mapper.readValue(inputStream, new TypeReference<List<SurahDto>>() {});

        List<SurahEntity> entities = dtos.stream()
                .map(surahMapper::toEntity)
                .collect(Collectors.toList());

        surahrepo.saveAll(entities);

        System.out.println("تم تحميل السور بنجاح إلى قاعدة البيانات.");
    }

}
