package com.example.android.bakeapp.fragments;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakeapp.R;
import com.example.android.bakeapp.models.Step;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailStepListFragment extends Fragment {

    private Step currentStep;

    //TODO(CRITICAL) AGREGAR AQUI EL SIMPLE MEDIA PLAYER DE EXOPLAYER
    @BindView(R.id.texview_item_step_description)
    TextView mTvItemStepDetailDescription;


    static DetailStepListFragment newInstance(Step thisStep) {
        DetailStepListFragment newFragment = new DetailStepListFragment();
        Bundle args = new Bundle();
        args.putParcelable("current_step", thisStep);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pager_item_list, container, false);
        ButterKnife.bind(this, rootView);
        mTvItemStepDetailDescription.setText(currentStep.getDescription());
        return rootView;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentStep = getArguments().getParcelable("current_step");
        } else {
            currentStep = null;
        }
    }

}
