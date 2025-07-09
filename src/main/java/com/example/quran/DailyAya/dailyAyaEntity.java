// Fixed Entity
package com.example.quran.DailyAya;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp; // Fixed import - was java.security.Timestamp

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class dailyAyaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dailyAya;

    private Timestamp time;
}
