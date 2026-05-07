package com.animewatchlist.watchlist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private int episodes;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    private int rating;
    private String notes;
    private int userId;
}
