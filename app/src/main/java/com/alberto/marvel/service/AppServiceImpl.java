package com.alberto.marvel.service;

import com.alberto.marvel.common.model.response.CharactersResponse;

import rx.Observable;

public class AppServiceImpl implements AppService {
    private final ApiClient apiClient;

    public AppServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Observable<CharactersResponse> getAllCharacters(String publicKey, String md5Digest, long timestamp) {
        return apiClient.getService().getAllCharacters(publicKey, md5Digest, timestamp);
    }
}
