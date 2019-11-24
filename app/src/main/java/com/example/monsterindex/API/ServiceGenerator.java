package com.example.monsterindex.API;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("http://dnd5eapi.co")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MonsterAPI monsterApi = retrofit.create(MonsterAPI.class);

    public static MonsterAPI getMonsterApi() {
        return monsterApi;
    }
}
