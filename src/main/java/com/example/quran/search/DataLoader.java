package com.example.quran.search;

import com.example.quran.search.AyaJsonLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AyaJsonLoader loader;

    public DataLoader(AyaJsonLoader loader) {
        this.loader = loader;
    }

    @Override
    public void run(String... args) {
        loader.loadFromJson();
    }
}
