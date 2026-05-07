package com.animewatchlist.watchlist.repository;

import com.animewatchlist.watchlist.model.Anime;
import com.animewatchlist.watchlist.model.STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer>{
    Optional<Object> findAllById(int userId);

    List<Anime> findByUserId(int userId);

    List<Anime> findAllByStatus(STATUS status);

    List<Anime> findByGenreIgnoreCase(String genre);
}
