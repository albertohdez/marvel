package com.alberto.marvel.service;

import com.alberto.marvel.common.model.response.CharactersResponse;

import rx.Observable;

public interface AppService {
    Observable<CharactersResponse> getAllCharacters(String publicKey, String md5Digest, long timestamp);
}
