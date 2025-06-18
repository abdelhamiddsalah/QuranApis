package com.example.quran.Surahs;

import com.example.quran.Ayat.AyaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurahWithAyatDto  {
    private SurahDto surah;
    private List<AyaDto> ayat;
}
