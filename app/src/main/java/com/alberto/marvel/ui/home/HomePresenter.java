package com.alberto.marvel.ui.home;


import com.alberto.marvel.common.view.presenter.BasePresenter;
import com.alberto.marvel.service.AppService;

public class HomePresenter extends BasePresenter<HomeMvpView> {
    private final AppService appService;

    public HomePresenter(AppService appService) {
        this.appService = appService;
    }
}
