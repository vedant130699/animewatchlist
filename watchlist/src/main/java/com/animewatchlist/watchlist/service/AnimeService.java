package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.model.STATUS;

import java.util.List;


public interface AnimeService {

    List<Anime> getAllAnime();

    Anime addAnime(Anime anime);

    void deleteAnime(int id);

    Anime getAnimeById(int id);

    Anime updateAnime(int id, Anime anime);

    List<Anime> addBulkAnime(List<Anime> anime);

    List<Anime> getAllAnimeByUserId(int userId);

    List<Anime> getAnimeByStatus(STATUS status);

    List<Anime> getAnimeByGenre(String genre);
}
