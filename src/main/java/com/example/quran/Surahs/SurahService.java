package com.example.quran.Surahs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurahService {

    @Autowired
    private SurahRepo surahrepo;

    @Autowired
    private SurahMapper surahMapper;

    public List<SurahDto> getAllSurahs() {
        return surahrepo.findAll()
                .stream()
                .map(surahMapper::toDto)
                .distinct()
                .collect(Collectors.toList());
    }

    // ✅ إضافة دالة لإرجاع سورة واحدة بـ id
    public SurahDto getSurahById(Long id) {
        return surahMapper.toDto(
                surahrepo.findById(id)
                        .orElseThrow(() -> new RuntimeException("Surah not found"))
        );
    }
}
