package com.alberto.marvel.injection.component;

import android.app.Activity;

import com.alberto.marvel.injection.annotation.PerActivity;
import com.alberto.marvel.injection.module.ActivityModule;
import com.alberto.marvel.ui.home.HomeActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Activities
    Activity activity();

    void inject(HomeActivity homeActivity);

}
