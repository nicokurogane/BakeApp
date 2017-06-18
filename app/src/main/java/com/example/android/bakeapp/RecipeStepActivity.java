package com.example.android.bakeapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.bakeapp.models.Recipe;

public class RecipeStepActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step);

        //TODO (MEDIUM)  the first item of the recyclerview the list of ingredients
        //TODO (CRITICAL) integrate logic to show the master detail here

        Intent intent = getIntent();

        if(intent.hasExtra(getString(R.string.extra_intent_recipe))){
            Recipe recipe = intent.getParcelableExtra(getString(R.string.extra_intent_recipe));
            ActionBar bar = getSupportActionBar();
            bar.setTitle(recipe.getName());
        }


        mTwoPane = false;

    }
}
