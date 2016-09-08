package com.minano.themovielibrary.controllers;

import com.minano.themovielibrary.models.DetailItem;

import java.util.List;

/**
 * Created by Admin on 07/09/2016.
 */
public interface ItemCallerResponse {
    public void onCompleted(List<DetailItem> itemList);
}
