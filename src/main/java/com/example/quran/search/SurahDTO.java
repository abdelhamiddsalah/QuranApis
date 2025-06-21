package com.example.quran.search;// SurahDTO.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurahDTO {
    private int id;
    private String name;
    private String transliteration;
    private String type;
    private int total_verses;
    private List<VerseDTO> verses;

    // getters and setters
}
