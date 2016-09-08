package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.FilmItem;

import java.util.List;

/**
 * Created by Admin on 18/08/2016.
 */
public interface ITVShowController {
    public List<FilmItem> getLatestFilmList();
    public List<FilmItem> getTopRatedFilmList();
    public List<FilmItem> getMostPopularListFilms();
    public FilmItem getFilm(int id);
}
