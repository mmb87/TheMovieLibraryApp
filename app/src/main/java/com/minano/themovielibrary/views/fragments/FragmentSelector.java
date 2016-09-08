package com.minano.themovielibrary.views.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minano.themovielibrary.R;
import com.minano.themovielibrary.controllers.FilmController;
import com.minano.themovielibrary.controllers.IFilmController;
import com.minano.themovielibrary.controllers.ItemCaller;
import com.minano.themovielibrary.controllers.ItemCallerResponse;
import com.minano.themovielibrary.models.DetailItem;
import com.minano.themovielibrary.views.ItemAdapter;

import java.util.List;

/**
 * Created by Admin on 31/08/2016.
 */
public class FragmentSelector extends Fragment {
    private Activity activity;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<DetailItem> detailItemList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
            itemAdapter = new ItemAdapter(context);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(itemAdapter);
        new ItemCaller(2, new ItemCallerResponse() {
            @Override
            public void onCompleted(List<DetailItem> itemList) {
                itemAdapter.setDetailItemList(itemList);
                itemAdapter.notifyDataSetChanged();
            }
        }).execute();
        itemAdapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

//    private class ItemCaller extends AsyncTask<Void, Void, List<DetailItem>> {
//
//        @Override
//        protected List<DetailItem> doInBackground(Void... params) {
//            List<DetailItem> itemList = new FilmController().getTopRatedFilmList();
//            return itemList;
//        }
//
//        @Override
//        protected void onPostExecute(List<DetailItem> itemList) {
//            itemAdapter.setDetailItemList(itemList);
//            itemAdapter.notifyDataSetChanged();
//        }
//    }

}
