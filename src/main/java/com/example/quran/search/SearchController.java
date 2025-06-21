package com.example.quran.search;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public List<AyaSearchEntity> searchAyat(@RequestParam String keyword) {
        return searchService.searchAyat(keyword);
    }
}
