package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;
import com.minano.themovielibrary.models.FilmItem;

import java.util.List;

/**
 * Created by Admin on 18/08/2016.
 */
public interface IFilmController {

    public List<DetailItem> getLatestFilmList();
    public List<DetailItem> getTopRatedFilmList();
    public List<DetailItem> getMostPopularListFilms();
    public FilmItem getFilm(int id);
}
