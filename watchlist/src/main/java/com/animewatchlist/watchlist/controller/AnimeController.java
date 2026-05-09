package com.animewatchlist.watchlist.controller;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.dto.AnimeDTO;
import com.animewatchlist.watchlist.model.STATUS;
import com.animewatchlist.watchlist.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService){
        this.animeService = animeService;
    }
    @GetMapping("/anime")
    public ResponseEntity<List<AnimeDTO>> getAnime(){
        return ResponseEntity.ok(animeService.getAllAnime());
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<AnimeDTO> getAnimeById(@PathVariable int id){
        return ResponseEntity.ok(animeService.getAnimeById(id));
    }

    @GetMapping("/anime/userId/{userId}")
    public ResponseEntity<List<AnimeDTO>> getAnimeByUserId(@PathVariable int userId){
        return ResponseEntity.ok(animeService.getAllAnimeByUserId(userId));
    }

    @GetMapping("/anime/status/{status}")
    public ResponseEntity<List<AnimeDTO>>  getAnimeByStatus(@PathVariable STATUS status){
        return ResponseEntity.ok(animeService.getAnimeByStatus(status));
    }
    @GetMapping("/anime/genre/{genre}")
    public ResponseEntity<List<AnimeDTO>>  getAnimeByGenre(@PathVariable String genre){
        return ResponseEntity.ok(animeService.getAnimeByGenre(genre));
    }


    @PostMapping("/anime")
    public ResponseEntity<AnimeDTO> postAnime(@RequestBody Anime anime){
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.addAnime(anime)) ;
    }

    @PostMapping("/anime/bulk")
    public ResponseEntity<List<AnimeDTO>>  addBulkAnime(@RequestBody List<Anime> anime){
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.addBulkAnime(anime));
    }

    @DeleteMapping("/anime/{id}")
    public ResponseEntity<Void> deleteAnime(@PathVariable int id){
        animeService.deleteAnime(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/anime/{id}")
    public ResponseEntity<AnimeDTO> updateAnime(@PathVariable int id, @RequestBody Anime anime){
        AnimeDTO updatedAnime =  animeService.updateAnime(id, anime);
        return ResponseEntity.ok(updatedAnime);
    }


}
