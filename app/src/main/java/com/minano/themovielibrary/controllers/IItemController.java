package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;

import java.util.List;

/**
 * Created by Admin on 30/08/2016.
 */
public interface IItemController {
    public List<DetailItem> getItemList(String stringUrl);

}
