package com.example.quran.search;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AyaSearch")
public class AyaSearchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Aya_search_id;

    @Column(columnDefinition = "TEXT")
    private String ayaText;

    private int ayaNumber;

    @Column(columnDefinition = "TEXT")
    private String ayaTextStripped; // بدون تشكيل

    private  String surahName;

}
