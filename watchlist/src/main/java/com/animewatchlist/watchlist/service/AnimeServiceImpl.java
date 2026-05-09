package com.animewatchlist.watchlist.service;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.dto.AnimeDTO;
import com.animewatchlist.watchlist.model.STATUS;
import com.animewatchlist.watchlist.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService{

    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }

    public AnimeDTO convertToDTO(Anime anime){
        AnimeDTO dto = new AnimeDTO();
        dto.setId(anime.getId());
        dto.setTitle(anime.getTitle());
        dto.setStatus(anime.getStatus());

        return dto;
    }

    @Override
    public List<AnimeDTO> getAllAnime() {
        return animeRepository.findAll()
                .stream().map(this::convertToDTO)
                .toList();
    }

    @Override
    public AnimeDTO addAnime(Anime anime) {
        Anime anime1 =  animeRepository.save(anime);
        return convertToDTO(anime1);
    }

    @Override
    public void deleteAnime(int id) {
        animeRepository.deleteById(id);

    }

    @Override
    public AnimeDTO getAnimeById(int id) {
        Anime anime = animeRepository.findById(id).orElseThrow(() -> new RuntimeException("Anime does not exist with id: " +id));;
        return convertToDTO(anime);
    }

        @Override
        public AnimeDTO updateAnime(int id, Anime updateAnime) {
            Anime existingAnime = animeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Anime not found for id: "+ id));

            existingAnime.setTitle(updateAnime.getTitle());
            existingAnime.setEpisodes(updateAnime.getEpisodes());
            existingAnime.setGenre(updateAnime.getGenre());
            existingAnime.setStatus(updateAnime.getStatus());
            existingAnime.setRating(updateAnime.getRating());
            existingAnime.setNotes(updateAnime.getNotes());
            existingAnime.setUserId(updateAnime.getUserId());
            Anime updatedAnime = animeRepository.save(existingAnime);
            return convertToDTO(updatedAnime);


        }

    @Override
    public List<AnimeDTO> addBulkAnime(List<Anime> anime) {
        List<Anime> allAnime =  animeRepository.saveAll(anime);
        return allAnime.stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<AnimeDTO> getAllAnimeByUserId(int userId) {
        List<Anime> anime =  animeRepository.findByUserId(userId);
        return anime.stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<AnimeDTO> getAnimeByStatus(STATUS status) {
        List<Anime> anime =  animeRepository.findAllByStatus(status);
        return anime.stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<AnimeDTO> getAnimeByGenre(String genre) {
        List<Anime> anime =  animeRepository.findByGenreIgnoreCase(genre);
        return anime.stream().map(this::convertToDTO).toList();
    }


}
