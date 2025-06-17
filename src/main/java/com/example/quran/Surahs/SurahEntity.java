// SurahEntity.java
package com.example.quran.Surahs;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "surahs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurahEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name; // لو مش هتستخدمه، ممكن تشيله

    @Column(name = "arabic_name")
    private String arabicName;

    @Column(name = "number")
    private Integer number;

    @Column(name = "verses_count")
    private Integer versesCount;

    @Column(name = "revelation_place")
    private String revelationPlace;
}
