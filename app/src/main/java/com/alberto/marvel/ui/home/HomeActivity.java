package com.alberto.marvel.ui.home;

import android.os.Bundle;

import com.alberto.marvel.R;
import com.alberto.marvel.common.model.response.ResultResponse;
import com.alberto.marvel.common.view.activity.BaseActivity;

import java.util.List;

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
        homePresenter.getAllCharacters();
    }

    @Override
    public void getAllCharactersSuccess(List<ResultResponse> charactersResult) {

    }

    @Override
    public void getAllCharactersError() {

    }
}
