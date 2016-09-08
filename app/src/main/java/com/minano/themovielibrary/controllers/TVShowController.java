package com.minano.themovielibrary.controllers;

import android.os.AsyncTask;

import com.minano.themovielibrary.models.FilmItem;

import java.util.List;

/**
 * Created by Admin on 18/08/2016.
 */
public class TVShowController implements ITVShowController {
    @Override
    public List<FilmItem> getLatestFilmList() {
        return null;
    }

    @Override
    public List<FilmItem> getTopRatedFilmList() {
        return null;
    }

    @Override
    public List<FilmItem> getMostPopularListFilms() {
        return null;
    }

    @Override
    public FilmItem getFilm(int id) {
        return null;
    }

    private class DataCaller extends AsyncTask
    {

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }
    }
}
