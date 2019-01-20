package com.example.android.bakeapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.bakeapp.models.Recipe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity represents the screen were we will show our two pane screen
 * while on cellphones, it will show just the step
 */
public class RecipeStepActivity extends AppCompatActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step);

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
