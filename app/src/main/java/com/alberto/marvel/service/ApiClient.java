package com.alberto.marvel.service;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.alberto.marvel.common.constants.Constants.API_URL;

public class ApiClient {

    private Retrofit restAdapter;
    private MarvelService service;

    public MarvelService getService() {
        if (restAdapter == null || service == null) {
            restAdapter = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            service = restAdapter.create(MarvelService.class);
        }

        return service;
    }
}
