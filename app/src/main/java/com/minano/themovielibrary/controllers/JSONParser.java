package com.minano.themovielibrary.controllers;

import android.util.Log;

import com.minano.themovielibrary.models.DetailItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 29/08/2016.
 */
public class JSONParser {
    private final static String TAG = "JSONParser";

    public List<DetailItem> parseResponse(String response) {
        Log.d(TAG, response);
        List<DetailItem> filmList = new ArrayList<DetailItem>();
        try {
            JSONObject jsonObject = new JSONObject(response);

            JSONArray jsonArray = (JSONArray) jsonObject.get("results");
            for (int i = 0; i<jsonArray.length(); i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                DetailItem detailItem = new DetailItem();
                detailItem.setId(object.getInt("id"));
                detailItem.setTitle(object.getString("title"));
                detailItem.setReleaseDate(object.getString("release_date"));
                detailItem.setPoints(object.getInt("vote_average"));
                detailItem.setVotes(object.getInt("vote_count"));
                detailItem.setImageString(object.getString("poster_path"));
                filmList.add(detailItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return filmList;
    }
}
