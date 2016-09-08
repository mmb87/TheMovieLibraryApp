package com.minano.themovielibrary.views;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minano.themovielibrary.controllers.FilmController;
import com.minano.themovielibrary.helpers.ImageDownloader;
import com.minano.themovielibrary.R;
import com.minano.themovielibrary.models.DetailItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 31/08/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    final public static String TAG = "ItemAdapter";

    private LayoutInflater inflator;
    private List<DetailItem> detailItemList;
    private View.OnClickListener onClickListener;
    private ImageDownloader imageDownloader;

//    public ItemAdapter(Context context, List<DetailItem> detailItemList) {
//        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.detailItemList = detailItemList;
//    }

    public ItemAdapter(Context context) {
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        detailItemList = new ArrayList<DetailItem>();
    }

    public void setDetailItemList(List<DetailItem> detailItemList) {
        this.detailItemList = detailItemList;
        this.notifyItemRangeInserted(0 , detailItemList.size()-1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflator.inflate(R.layout.selector_item, null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DetailItem detailItem = detailItemList.get(position);
        Log.d(TAG, detailItem.toString());
        holder.title.setText(detailItem.getTitle());
        holder.releaseDate.setText(detailItem.getReleaseDate());
        holder.score.setText(String.valueOf(detailItem.getPoints()));
        holder.votes.setText(String.valueOf(detailItem.getVotes()));
        imageDownloader = new ImageDownloader(detailItem.getImageString(), holder.image);
        imageDownloader.execute();
//        holder.itemView.setScaleX(1);
//        holder.itemView.setScaleY(1);
    }

    @Override
    public int getItemCount() {
        return detailItemList.size();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView releaseDate;
        public TextView votes;
        public TextView score;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            releaseDate = (TextView) itemView.findViewById(R.id.release_date);
            votes = (TextView) itemView.findViewById(R.id.vote_count);
            score = (TextView) itemView.findViewById(R.id.score);
        }
    }

}
