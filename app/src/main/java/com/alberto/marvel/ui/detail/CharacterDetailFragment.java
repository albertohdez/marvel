package com.alberto.marvel.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alberto.marvel.R;
import com.alberto.marvel.common.model.response.ResultResponse;
import com.alberto.marvel.common.view.activity.BaseActivity;
import com.alberto.marvel.ui.detail.wrapper.ComicWrapper;
import com.alberto.marvel.ui.detail.wrapper.DescriptionWrapper;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterDetailFragment extends Fragment {
    public static final String TAG = CharacterDetailFragment.class.getCanonicalName();
    private static final String EXTRA_CHARACTER = "extra_character";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.backdrop)
    ImageView backdrop;

    @BindView(R.id.detailsContent)
    LinearLayout detailsContent;

    public static CharacterDetailFragment newInstance(ResultResponse character) {
        CharacterDetailFragment fragment = new CharacterDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_CHARACTER, character);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
        ((BaseActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ResultResponse character = getArguments().getParcelable(EXTRA_CHARACTER);
        if (character != null) {
            setupUI(character);
        }
    }

    private void setupUI(ResultResponse character) {
        Glide.with(this)
                .load(character.getImageUrl())
                .centerCrop()
                .into(backdrop);
        collapsingToolbar.setTitle(character.getName());

        if (!character.getDescription().isEmpty()) {
            DescriptionWrapper descriptionWrapper = new DescriptionWrapper(getActivity(), character.getDescription());
            detailsContent.addView(descriptionWrapper);
        }

        List<String> characterComics = character.getComics().getComicNames();
        if (!characterComics.isEmpty()) {
            ComicWrapper comicWrapper = new ComicWrapper(getActivity(), getString(R.string.comics), characterComics);
            detailsContent.addView(comicWrapper);
        }

        List<String> characterSeries = character.getSeries().getSerieNames();
        if (!characterSeries.isEmpty()) {
            ComicWrapper serieWrapper = new ComicWrapper(getActivity(), getString(R.string.series), characterSeries);
            detailsContent.addView(serieWrapper);
        }

        List<String> characterStories = character.getStories().getStoryNames();
        if (!characterStories.isEmpty()) {
            ComicWrapper storyWrapper = new ComicWrapper(getActivity(), getString(R.string.stories), characterStories);
            detailsContent.addView(storyWrapper);
        }

        List<String> characterEvents = character.getEvents().getEventNames();
        if (!characterEvents.isEmpty()) {
            ComicWrapper eventWrapper = new ComicWrapper(getActivity(), getString(R.string.events), characterEvents);
            detailsContent.addView(eventWrapper);
        }
    }
}
