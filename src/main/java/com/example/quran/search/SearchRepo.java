package com.example.quran.search;

import com.example.quran.search.AyaSearchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepo extends JpaRepository<AyaSearchEntity, Long> {

    @Query("SELECT a FROM AyaSearchEntity a WHERE LOWER(a.ayaTextStripped) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<AyaSearchEntity> search(@Param("keyword") String keyword);


}
