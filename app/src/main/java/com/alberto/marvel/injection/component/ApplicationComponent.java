package com.alberto.marvel.injection.component;

import com.alberto.marvel.MApplication;
import com.alberto.marvel.common.view.activity.BaseActivity;
import com.alberto.marvel.injection.module.ApplicationModule;
import com.alberto.marvel.service.AppService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    void inject(MApplication application);

    AppService appService();
}
