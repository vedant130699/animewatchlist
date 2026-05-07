package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.model.STATUS;
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

        @Override
        public Anime updateAnime(int id, Anime updateAnime) {
            Anime existingAnime = animeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Anime not found for id: "+ id));

            existingAnime.setTitle(updateAnime.getTitle());
            existingAnime.setEpisodes(updateAnime.getEpisodes());
            existingAnime.setGenre(updateAnime.getGenre());
            existingAnime.setStatus(updateAnime.getStatus());
            existingAnime.setRating(updateAnime.getRating());
            existingAnime.setNotes(updateAnime.getNotes());
            existingAnime.setUserId(updateAnime.getUserId());
            return animeRepository.save(existingAnime);


        }

    @Override
    public List<Anime> addBulkAnime(List<Anime> anime) {
        return animeRepository.saveAll(anime);
    }

    @Override
    public List<Anime> getAllAnimeByUserId(int userId) {
        return  animeRepository.findByUserId(userId);
    }

    @Override
    public List<Anime> getAnimeByStatus(STATUS status) {
        return animeRepository.findAllByStatus(status);
    }

    @Override
    public List<Anime> getAnimeByGenre(String genre) {
        return animeRepository.findByGenreIgnoreCase(genre);
    }


}
