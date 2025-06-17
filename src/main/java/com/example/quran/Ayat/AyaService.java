package com.example.quran.Ayat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AyaService {

    @Autowired
    AyaRepo ayaRepo;

    @Autowired
    AyatMapper ayatMapper;

    public List<AyaDto> getAyatBySurahId(Long surahId) {
        return ayaRepo.findBySurah_Id(surahId)
                .stream()
                .map(ayatMapper::toDto)
                .distinct() // تجنب التكرار
                .collect(Collectors.toList());
    }
}
