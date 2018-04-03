
package com.alberto.marvel.ui.detail.wrapper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alberto.marvel.R;

import java.util.ArrayList;
import java.util.List;


public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {

    private final List<String> comicList;

    public ComicAdapter(List<String> comicList) {
        this.comicList = new ArrayList<>();
        addItems(comicList);
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comic, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.title.setText(comicList.get(position));

    }

    public void addItems(List<String> itemsList) {
        comicList.addAll(itemsList);
        notifyItemRangeInserted(getItemCount(), comicList.size() - 1);
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;

        public ComicViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tvTitle);
        }
    }

}
