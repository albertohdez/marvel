package com.alberto.marvel.injection.module;

import android.app.Activity;

import com.alberto.marvel.injection.annotation.PerActivity;
import com.alberto.marvel.service.AppService;
import com.alberto.marvel.ui.home.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }


    @Provides
    @PerActivity
    HomePresenter provideHomePresenter(AppService appService) {
        return new HomePresenter(appService);
    }

}
