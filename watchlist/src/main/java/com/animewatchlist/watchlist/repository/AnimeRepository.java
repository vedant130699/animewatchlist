package com.animewatchlist.watchlist.repository;

import com.animewatchlist.watchlist.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer>{
}
