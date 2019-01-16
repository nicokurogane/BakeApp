package com.example.android.bakeapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.bakeapp.R;
import com.example.android.bakeapp.RecipeStepDetailsActivity;
import com.example.android.bakeapp.adapters.StepIndexAdapter;
import com.example.android.bakeapp.models.Recipe;
import com.example.android.bakeapp.models.Step;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
* This fragment is used as the master view in a master-detail pattern, displaying a list of
* steps indicate in the recipe
*
* */
public class StepListFragment extends Fragment {

    //TODO(MEDIUM) CREATE ONCLICK LISTENER FOR INTERFACE

    private StepIndexAdapter mAdapter;
    private Recipe recipe;

    @BindView(R.id.recyclerview_step_index)
    RecyclerView mRvStepIndex;

    public StepListFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_step_list, container, false);
        ButterKnife.bind(this, rootView);

        List<Step> dummy = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new StepIndexAdapter(dummy, new StepIndexAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Step step) {
                Toast.makeText(getContext(), step.getShortDescription(), Toast.LENGTH_SHORT).show();

                //we'll send the list of the current recipe
                ArrayList<Step> currentStepList = new ArrayList<>(recipe.getSteps());


                Intent intent = new Intent(getActivity(), RecipeStepDetailsActivity.class);
                Bundle b = new Bundle();
                b.putParcelableArrayList(getString(R.string.extra_intent_step), currentStepList);
                b.putString(getString(R.string.extra_intent_recipe_name), recipe.getName());
                //get the position of selected step
                b.putInt( getString(R.string.extra_intent_selected_step) , currentStepList.indexOf(step));
                intent.putExtra(getString(R.string.extra_intent_bundle), b);

                startActivity(intent);
            }
        });

        mRvStepIndex.setLayoutManager(layoutManager);
        mRvStepIndex.setHasFixedSize(true);
        mRvStepIndex.setAdapter(mAdapter);

        //add divider
        DividerItemDecoration mDID = new DividerItemDecoration(mRvStepIndex.getContext(), layoutManager.getOrientation());
        mRvStepIndex.addItemDecoration(mDID);

        return rootView;
    }


    //HERE WE SET THE DATA NEEDED FOR THE ADAPTER
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intentReceived = getActivity().getIntent();

        if (intentReceived.hasExtra(getString(R.string.extra_intent_recipe))) {

            recipe = intentReceived.getParcelableExtra(getString(R.string.extra_intent_recipe));
            mAdapter.updateStepList(recipe.getSteps());
        }

    }

}
