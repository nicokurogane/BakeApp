package com.example.android.bakeapp.interfaces;

import com.example.android.bakeapp.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * THIS INTERFACE ITS OBLIGATORY TO RETROFIT  SO IT CAN PERFORM THE NETWORK REQUEST
 * */
public interface RecipeService {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> recipes();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://d17h27t6h515a5.cloudfront.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
