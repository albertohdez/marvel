package com.alberto.marvel;

import android.app.Application;

import com.alberto.marvel.injection.component.ApplicationComponent;
import com.alberto.marvel.injection.component.DaggerApplicationComponent;
import com.alberto.marvel.injection.module.ApplicationModule;

public class MApplication extends Application {

    private ApplicationComponent applicationComponent = createAppComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent createAppComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
