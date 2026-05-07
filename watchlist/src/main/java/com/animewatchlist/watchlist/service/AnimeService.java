package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;

import java.util.List;


public interface AnimeService {

    List<Anime> getAllAnime();

    Anime addAnime(Anime anime);

    void deleteAnime(int id);

    Anime getAnimeById(int id);

    Anime updateAnime(int id, Anime anime);
}
