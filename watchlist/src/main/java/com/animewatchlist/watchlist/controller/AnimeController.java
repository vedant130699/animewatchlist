package com.animewatchlist.watchlist.controller;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.model.STATUS;
import com.animewatchlist.watchlist.service.AnimeService;
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
    public List<Anime> getAnime(){
        return animeService.getAllAnime();
    }

    @GetMapping("anime/{id}")
    public Anime getAnimeById(@PathVariable int id){
        return animeService.getAnimeById(id);
    }

    @GetMapping("/anime/userId/{userId}")
    public List<Anime> getAnimeByUserId(@PathVariable int userId){
        return animeService.getAllAnimeByUserId(userId);
    }

    @GetMapping("/anime/status/{status}")
    public List<Anime> getAnimeByStatus(@PathVariable STATUS status){
        return animeService.getAnimeByStatus(status);
    }
    @GetMapping("/anime/genre/{genre}")
    public List<Anime> getAnimeByGenre(@PathVariable String genre){
        return animeService.getAnimeByGenre(genre);
    }


    @PostMapping("/anime")
    public Anime postAnime(@RequestBody Anime anime){
        return animeService.addAnime(anime);
    }

    @PostMapping("/bulkAnime")
    public List<Anime> addBulkAnime(@RequestBody List<Anime> anime){
        return animeService.addBulkAnime(anime);
    }

    @DeleteMapping("/anime/{id}")
    public void deleteAnime(@PathVariable int id){
        animeService.deleteAnime(id);
    }

    @PutMapping("/anime/{id}")
    public Anime updateAnime(@PathVariable int id, @RequestBody Anime anime){
        return animeService.updateAnime(id, anime);
    }


}
