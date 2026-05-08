package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.dto.AnimeDTO;
import com.animewatchlist.watchlist.model.STATUS;

import java.util.List;


public interface AnimeService {

    List<AnimeDTO> getAllAnime();

    AnimeDTO addAnime(Anime anime);

    void deleteAnime(int id);

    AnimeDTO getAnimeById(int id);

    AnimeDTO updateAnime(int id, Anime anime);

    List<AnimeDTO> addBulkAnime(List<Anime> anime);

    List<AnimeDTO> getAllAnimeByUserId(int userId);

    List<AnimeDTO> getAnimeByStatus(STATUS status);

    List<AnimeDTO> getAnimeByGenre(String genre);
}
