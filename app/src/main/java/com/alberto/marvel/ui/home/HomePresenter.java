package com.alberto.marvel.ui.home;

import com.alberto.marvel.common.model.response.CharactersResponse;
import com.alberto.marvel.common.utils.Utils;
import com.alberto.marvel.common.view.presenter.BasePresenter;
import com.alberto.marvel.service.AppService;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.alberto.marvel.common.constants.Constants.PUBLIC_KEY;

public class HomePresenter extends BasePresenter<HomeMvpView> {
    private final AppService appService;

    public HomePresenter(AppService appService) {
        this.appService = appService;
    }

    public void getAllCharacters() {
        long timeStamp = System.currentTimeMillis();
        addRxSubscription(appService.getAllCharacters(PUBLIC_KEY, Utils.buildMd5AuthParameter(timeStamp), timeStamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CharactersResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().getAllCharactersError();
                    }

                    @Override
                    public void onNext(CharactersResponse charactersResponse) {
                        getMvpView().getAllCharactersSuccess(charactersResponse);
                    }
                })
        );
    }


}
