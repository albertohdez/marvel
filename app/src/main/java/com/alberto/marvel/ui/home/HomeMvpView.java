package com.alberto.marvel.ui.home;

import com.alberto.marvel.common.model.response.ResultResponse;
import com.alberto.marvel.common.view.presenter.MvpView;

import java.util.List;

public interface HomeMvpView extends MvpView {
    void getAllCharactersSuccess(List<ResultResponse> charactersResult);

    void getAllCharactersError();
}
