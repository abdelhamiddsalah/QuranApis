package com.example.quran.Ayat;

import com.example.quran.Surahs.SurahEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ayat")
public class AyaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aya_number") // اضبط العمود هنا
    private int ayaNumber;


    @Column(name = "aya_text")
    private String AyaText;



    @Column(name = "aya_tafsir",columnDefinition = "TEXT")
    private String AyaTafsir;

    @Column(name = "audiourl")
    private String AudioUrl;

    // 👇 العلاقة مع السورة
    @ManyToOne
    @JoinColumn(name = "surah_id") // لازم يكون العمود ده موجود في جدول ayat
    private SurahEntity surah;
}
