package com.example.android.bakeapp;

import android.content.Intent;
import android.os.Bundle;


import android.util.Log;

import com.example.android.bakeapp.fragments.DetailStepPagerAdapter;
import com.example.android.bakeapp.models.Step;

import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeStepDetailsActivity extends AppCompatActivity {


    @BindView(R.id.viewpager_step_detail)
    ViewPager mStepsPager;

    private DetailStepPagerAdapter mRecipeStepPagerAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step_detail);
        ButterKnife.bind(this);

        Intent receivedIntent = getIntent();

        //we check if this activity has the list of instruction so we can create
        //the viewpager with the steps.
        if (receivedIntent.hasExtra(getString(R.string.extra_intent_bundle))) {

            Bundle b = receivedIntent.getBundleExtra(getString(R.string.extra_intent_bundle));
            List<Step> mStepList = b.getParcelableArrayList(getString(R.string.extra_intent_step));
            mRecipeStepPagerAdapter = new DetailStepPagerAdapter(getSupportFragmentManager(), mStepList);
            mStepsPager.setAdapter(mRecipeStepPagerAdapter);

            if (b.containsKey(getString(R.string.extra_intent_recipe_name))) {
                String recipe = b.getString(getString(R.string.extra_intent_recipe_name));
                ActionBar bar = getSupportActionBar();
                bar.setTitle(recipe);
            }

            //check if the step selected is other than zero
            if (b.containsKey(getString(R.string.extra_intent_selected_step))) {
                int position = b.getInt(getString(R.string.extra_intent_selected_step));
                mStepsPager.setCurrentItem(position);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("StepsDetailsOnDestroy", "Activity Destroyed");
    }
}
