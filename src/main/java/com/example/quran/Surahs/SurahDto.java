package com.example.quran.Surahs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurahDto {

    private Long id;

    @JsonProperty("nameArabic") // يربط nameArabic في JSON بـ arabicName في الكود
    private String arabicName;

    @JsonProperty("orderInMushaf") // يربط orderInMushaf في JSON بـ number في الكود
    private Integer number;

    @JsonProperty("ayahCount") // يربط ayahCount في JSON بـ versesCount في الكود
    private Integer versesCount;

    private String revelationPlace;
}
