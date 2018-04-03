
package com.alberto.marvel.ui.detail.wrapper;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alberto.marvel.R;
import com.alberto.marvel.ui.detail.wrapper.adapter.ComicAdapter;

import java.util.List;

public class ComicWrapper extends LinearLayout {

    private TextView tvTitle;
    private ComicAdapter adapter;

    public ComicWrapper(Context context) {
        super(context);
    }

    public ComicWrapper(Context context, String title, List<String> comicList) {
        super(context);
        adapter = new ComicAdapter(comicList);
        init(context);
        if (tvTitle == null) {
            return;
        }

        if (title != null && !title.isEmpty()) {
            tvTitle.setText(title);
        }
    }

    private void init(Context context) {
        inflate(context, R.layout.wrapper_comic, this);

        tvTitle = findViewById(R.id.tvTitle);

        RecyclerView recyclerView = findViewById(R.id.rvComics);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setMotionEventSplittingEnabled(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
