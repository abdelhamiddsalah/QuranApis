package com.example.quran.Favourites;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favourites")
public class FavouritesController {

    @Autowired
    private FavouritesService  favouritesService;

    @PostMapping("/{surahId}/{ayaId}")
  public   ResponseEntity<FavouriteEntity> AddFavourite(
            @PathVariable Long surahId,
            @PathVariable Long ayaId
    ){
        FavouriteEntity favouritesRequest=favouritesService.addFavourite(surahId,ayaId);
        return ResponseEntity.ok().body(favouritesRequest);
    }

    @GetMapping
    public ResponseEntity<List<FavouriteEntity>> getFavourites(){
        return ResponseEntity.ok().body(favouritesService.getFavourites());
    }
}
