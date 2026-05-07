package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServiceImpl implements AnimeService{

    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }

    @Override
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    @Override
    public Anime addAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public void deleteAnime(int id) {
        animeRepository.deleteById(id);

    }

    @Override
    public Anime getAnimeById(int id) {
        Optional<Anime> anime = animeRepository.findById(id);
        return anime.orElseThrow(() -> new RuntimeException("Anime does not exist with id: " +id));
    }


}
