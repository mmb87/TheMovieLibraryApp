package com.minano.themovielibrary.controllers;

import android.os.AsyncTask;

import com.minano.themovielibrary.models.DetailItem;

import java.util.List;

/**
 * Created by Admin on 07/09/2016.
 */
public class ItemCaller extends AsyncTask<Void, Void, List<DetailItem>> {

    private ItemCallerResponse callerResponse;
    private int itemFilter;

    public ItemCaller(int itemFilter, ItemCallerResponse callerResponse){
        this.callerResponse=callerResponse;
        this.itemFilter = itemFilter;
    }

    @Override
    protected List<DetailItem> doInBackground(Void... params) {
//        List<DetailItem> itemList = new FilmController().getTopRatedFilmList();
        List<DetailItem> itemList = new ItemFilterController().getSelectedItem(itemFilter);
        return itemList;
    }

    @Override
    protected void onPostExecute(List<DetailItem> itemList) {
        callerResponse.onCompleted(itemList);
    }
}