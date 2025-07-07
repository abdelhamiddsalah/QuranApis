package com.example.quran.Favourites;


import com.example.quran.Auth.AppUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@RestController
@RequestMapping("/api/favourites")
public class FavouritesController {

    @Autowired
    private FavouritesService favouritesService;

    @PostMapping("/{surahId}/{ayaId}")
    public ResponseEntity<FavouriteEntity> AddFavourite(
            @PathVariable Long surahId,
            @PathVariable Long ayaId,
            @AuthenticationPrincipal AppUserEntity user
    ) {
        FavouriteEntity favourite = favouritesService.addFavourite(surahId, ayaId, user);
        return ResponseEntity.ok().body(favourite);
    }

    @GetMapping
    public ResponseEntity<List<FavouriteEntity>> getFavourites(@AuthenticationPrincipal AppUserEntity user) {
        return ResponseEntity.ok().body(favouritesService.getFavourites(user));
    }

    @GetMapping("/is-favourite/{surahId}/{ayaId}")
    public ResponseEntity<Boolean> isFavourite(
            @PathVariable Long surahId,
            @PathVariable Long ayaId,
            @AuthenticationPrincipal AppUserEntity user
    ) {
        return ResponseEntity.ok().body(favouritesService.IsFavourite(surahId, ayaId, user));
    }

}
