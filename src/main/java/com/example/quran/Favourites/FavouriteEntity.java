package com.example.quran.Favourites;

import com.example.quran.Ayat.AyaEntity;
import com.example.quran.Surahs.SurahEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SurahEntity surah;

    @ManyToOne
    private AyaEntity aya;

    // Getters and Setters
}
