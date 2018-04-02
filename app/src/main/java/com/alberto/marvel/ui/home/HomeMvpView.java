package com.alberto.marvel.ui.home;

import com.alberto.marvel.common.model.response.CharactersResponse;
import com.alberto.marvel.common.view.presenter.MvpView;

public interface HomeMvpView extends MvpView {
    void getAllCharactersSuccess(CharactersResponse charactersResponse);

    void getAllCharactersError();
}
