package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;
import com.minano.themovielibrary.models.FilmItem;

import java.util.List;


/**
 * Created by Admin on 18/08/2016.
 */
public class FilmController implements IFilmController{
    private static final String API_KEY = "5300b939a689dbb7cc14fae0dc554a9e";
    private static final String LATEST_FILMS_URL = "http://api.themoviedb.org/3/movie/latest?api_key="+API_KEY;
    private static final String TOPRATED_FILMS_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key="+API_KEY;
    private static final String MOSTPOPULAR_FILMS_URL = "http://api.themoviedb.org/3/movie/popular?api_key="+API_KEY;


    @Override
    public List<DetailItem> getLatestFilmList() {
        String response = new HttpRetriever().getStringResponse(LATEST_FILMS_URL);
        return new JSONParser().parseResponse(response);
    }

    @Override
    public List<DetailItem> getTopRatedFilmList() {
        String response = new HttpRetriever().getStringResponse(TOPRATED_FILMS_URL);
        return new JSONParser().parseResponse(response);
    }

    @Override
    public List<DetailItem> getMostPopularListFilms() {
        String response = new HttpRetriever().getStringResponse(MOSTPOPULAR_FILMS_URL);
        return new JSONParser().parseResponse(response);
    }


    @Override
    public FilmItem getFilm(int id) {
        return null;
    }

}
