package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;

import java.util.List;

/**
 * Created by Admin on 07/09/2016.
 */
public class ItemFilterController extends ItemController {

    private static final String API_KEY = "5300b939a689dbb7cc14fae0dc554a9e";
//    private static final String LATEST_FILMS_URL = "http://api.themoviedb.org/3/movie/latest?api_key="+API_KEY;
    private static final String TOPRATED_FILMS_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key="+API_KEY;
    private static final String MOSTPOPULAR_FILMS_URL = "http://api.themoviedb.org/3/movie/popular?api_key="+API_KEY;
//    private static final String LATEST_TVSHOWS_URL = "http://api.themoviedb.org/3/tv/latest?api_key="+API_KEY;
    private static final String TOPRATED_TVSHOWS_URL = "http://api.themoviedb.org/3/tv/top_rated?api_key="+API_KEY;
    private static final String MOSTPOPULAR_TVSHOWS_URL = "http://api.themoviedb.org/3/tv/popular?api_key="+API_KEY;
    public static final int TOPRATED_FILMS = 1;
    public static final int MOSTPOPULAR_FILMS = 2;
//    public static final int LATEST_FILMS = 3;
    public static final int TOPRATED_TVSHOWS = 4;
    public static final int MOSTPOPULAR_TVSHOWS = 5;
//    public static final int LATEST_TVSHOWS = 6;


    public List<DetailItem> getSelectedItem(int what){
        String url;
        switch (what){
            case TOPRATED_FILMS:
                url = TOPRATED_FILMS_URL;
                break;
            case MOSTPOPULAR_FILMS:
                url = MOSTPOPULAR_FILMS_URL;
            break;
            case TOPRATED_TVSHOWS:
                url = TOPRATED_TVSHOWS_URL;
            break;
            case MOSTPOPULAR_TVSHOWS:
                url = TOPRATED_TVSHOWS_URL;
            break;
            default:
                url = TOPRATED_FILMS_URL;
                break;
        }
        return getItemList(url);
    }

}
