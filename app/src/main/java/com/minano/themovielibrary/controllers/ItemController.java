package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;

import java.util.List;

/**
 * Created by Admin on 30/08/2016.
 */
public class ItemController implements IItemController {

    @Override
    public List<DetailItem> getItemList(String stringUrl) {
        String response = new HttpRetriever().getStringResponse(stringUrl);
        return new JSONParser().parseResponse(response);
    }
}
