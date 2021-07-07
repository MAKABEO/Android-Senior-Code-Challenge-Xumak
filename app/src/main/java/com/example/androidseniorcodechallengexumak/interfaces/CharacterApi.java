package com.example.androidseniorcodechallengexumak.interfaces;

import com.example.androidseniorcodechallengexumak.model.BreakingBadCharacter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterApi {

    @GET("characters")
    Call<List<BreakingBadCharacter>> getInfoData(@Query("limit") int limit,
                                                 @Query("offset") int offset);
}
