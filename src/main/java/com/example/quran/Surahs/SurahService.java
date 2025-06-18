package com.example.quran.Surahs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurahService {

    @Autowired
    private SurahRepo surahrepo;

    @Autowired
    private SurahMapper surahMapper;

    public List<SurahDto> getAllSurahs() {
        List<SurahDto> surahs= surahrepo.findAll()
                .stream()
                .map(surahMapper::toDto)
                .distinct()
                .toList();

        if (surahs.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Surah Not Found");
        }
        return surahs;
    }

    // ✅ إضافة دالة لإرجاع سورة واحدة بـ id
    public SurahDto getSurahById(Long id) {
        return surahMapper.toDto(
                surahrepo.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(  HttpStatus.NOT_FOUND,"Surah not found"))
        );
    }
}
