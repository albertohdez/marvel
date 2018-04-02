package com.alberto.marvel.ui.characters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alberto.marvel.R;
import com.alberto.marvel.common.model.response.CharactersResponse;
import com.alberto.marvel.common.model.response.ResultResponse;
import com.alberto.marvel.ui.characters.adapter.CharactersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersFragment extends Fragment implements CharactersAdapter.OnItemClickListener {
    public static final String TAG = CharactersFragment.class.getCanonicalName();
    private static final String EXTRA_CHARACTERS_RESULT = "extra_characters_result";

    @BindView(R.id.rvCharacters)
    RecyclerView rvCharacters;

    public static CharactersFragment newInstance(CharactersResponse charactersResponse) {
        CharactersFragment fragment = new CharactersFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_CHARACTERS_RESULT, charactersResponse);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CharactersResponse charactersResponse = getArguments().getParcelable(EXTRA_CHARACTERS_RESULT);

        if (charactersResponse != null && charactersResponse.getData() != null && charactersResponse.getData().getResults() != null
                && !charactersResponse.getData().getResults().isEmpty()) {
            createCharactersRecyclerView(charactersResponse.getData().getResults());
        } else {
            //TODO Empty view
        }

    }

    private void createCharactersRecyclerView(List<ResultResponse> results) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvCharacters.setLayoutManager(layoutManager);
        rvCharacters.setHasFixedSize(true);
        CharactersAdapter adapter = new CharactersAdapter(results);
        adapter.setOnItemClickListener(this);
        rvCharacters.setAdapter(adapter);
    }

    @Override
    public void onItemClick(ResultResponse character) {
        //TODO
    }
}
