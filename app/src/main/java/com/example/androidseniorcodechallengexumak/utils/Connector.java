package com.example.androidseniorcodechallengexumak.utils;

import com.example.androidseniorcodechallengexumak.interfaces.CharacterApi;
import com.example.androidseniorcodechallengexumak.model.BreakingBadCharacter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connector {

    private static final String BASE_URL="https://www.breakingbadapi.com/api/";
    private static Connector connector;
    private Retrofit retrofit;

    public Connector(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized Connector getInstance(){
        if (connector == null){
            connector = new Connector();
        }
        return connector;
    }
    public CharacterApi getInfoApi(){
        return retrofit.create(CharacterApi.class);
    }
}
