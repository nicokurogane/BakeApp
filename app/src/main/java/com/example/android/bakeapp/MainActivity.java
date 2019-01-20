package com.example.android.bakeapp;


import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.example.android.bakeapp.adapters.RecipesAdapter;
import com.example.android.bakeapp.interfaces.RecipeService;
import com.example.android.bakeapp.models.Recipe;
import com.example.android.bakeapp.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecipesAdapter mRecipeAdapter;

    @BindView(R.id.recyclerview_recipes)
    RecyclerView mRvRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        List<Recipe> dummy = new ArrayList<>();
        mRvRecipes.setLayoutManager(layoutManager);
        mRvRecipes.setHasFixedSize(true);

        mRecipeAdapter = new RecipesAdapter(dummy, new RecipesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe recipe) {
                Intent intent = new Intent(MainActivity.this, RecipeStepActivity.class);
                intent.putExtra(getString(R.string.extra_intent_recipe), recipe);
                startActivity(intent);
            }
        });

        mRvRecipes.setAdapter(mRecipeAdapter);

        if (GeneralUtils.hasInternetConnection(this)) {
            //load data
            RecipeService recipeService = RecipeService.retrofit.create(RecipeService.class);
            final Call<List<Recipe>> call = recipeService.recipes();

            //performing the network call on background
            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {

                    mRecipeAdapter.updateRecipeList(response.body());
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.e("onFailureRecipeLoad", t.getMessage());
                    Toast.makeText(MainActivity.this, "Couldn't get recipes!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            //show empty state and no internet error
            Toast.makeText(MainActivity.this, "NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
        }

    }


}
