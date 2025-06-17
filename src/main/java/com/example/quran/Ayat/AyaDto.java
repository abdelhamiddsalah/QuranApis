package com.example.quran.Ayat;

import com.example.quran.Surahs.SurahEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AyaDto {

    private int AyaNumber;
    private String AyaText;
    private String AyaTafsir;
    private String AudioUrl;
}
