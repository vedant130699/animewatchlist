package com.animewatchlist.watchlist.controller;

import com.animewatchlist.watchlist.model.Anime;
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

    @PostMapping("/anime")
    public Anime postAnime(@RequestBody Anime anime){
        return animeService.addAnime(anime);
    }

    @DeleteMapping("/anime/{id}")
    public void deleteAnime(@PathVariable int id){
        animeService.deleteAnime(id);
    }


}
