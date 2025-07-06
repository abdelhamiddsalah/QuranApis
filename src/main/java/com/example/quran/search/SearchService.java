package com.example.quran.search;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepo searchRepo;

    public SearchService(SearchRepo searchRepo) {
        this.searchRepo = searchRepo;
    }

    public List<AyaSearchEntity> searchAyat(String keyword) {
        // ✅ نزيل التشكيل من الكلمة التي كتبها المستخدم
        String cleanedKeyword = ArabicNormalizer.removeTashkeel(keyword);
        System.out.println("الكلمة بعد إزالة التشكيل: " + cleanedKeyword);

        List<AyaSearchEntity> result = searchRepo.search(cleanedKeyword);

        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Words Found");
        }

        return result;
    }



}
