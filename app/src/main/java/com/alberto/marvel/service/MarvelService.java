package com.alberto.marvel.service;


import com.alberto.marvel.common.model.response.CharactersResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MarvelService {
    @GET("characters")
    Observable<CharactersResponse> getAllCharacters(@Query("apikey") String publicKey,
                                                    @Query("hash") String md5Digest,
                                                    @Query("ts") long timestamp);
}
