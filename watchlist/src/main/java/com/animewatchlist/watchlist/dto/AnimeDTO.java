package com.animewatchlist.watchlist.dto;

import com.animewatchlist.watchlist.model.STATUS;

public class AnimeDTO {
    private int id;
    private String title;
    private STATUS status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
