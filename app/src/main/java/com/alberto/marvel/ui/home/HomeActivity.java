package com.alberto.marvel.ui.home;

import android.os.Bundle;
import android.view.MenuItem;

import com.alberto.marvel.R;
import com.alberto.marvel.common.model.response.CharactersResponse;
import com.alberto.marvel.common.view.activity.BaseActivity;
import com.alberto.marvel.ui.characters.CharactersFragment;
import com.alberto.marvel.ui.detail.CharacterDetailFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeMvpView {

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        homePresenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgressDialog();
        homePresenter.getAllCharacters();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(CharacterDetailFragment.TAG) != null) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void getAllCharactersSuccess(CharactersResponse charactersResponse) {
        dismissProgressDialog();
        CharactersFragment charactersFragment = CharactersFragment.newInstance(charactersResponse);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, charactersFragment,
                CharactersFragment.TAG).addToBackStack("").commit();
    }

    @Override
    public void getAllCharactersError() {
        dismissProgressDialog();
    }
}
