package com.example.monsterindex.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonsterAPI {
    @GET("api/monsters/{index}")
    Call<MonsterResponse> getMonster(@Path("index") int index);
}
