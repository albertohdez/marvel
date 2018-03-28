package com.alberto.marvel.injection.module;

import android.content.Context;

import com.alberto.marvel.MApplication;
import com.alberto.marvel.service.ApiClient;
import com.alberto.marvel.service.AppService;
import com.alberto.marvel.service.AppServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final MApplication rpApplication;

    public ApplicationModule(MApplication application) {
        rpApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return rpApplication;
    }

    @Provides
    @Singleton
    ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @Singleton
    AppService provideAppService(ApiClient apiClient) {
        return new AppServiceImpl(apiClient);
    }
}
