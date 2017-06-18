package com.example.android.bakeapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.bakeapp.models.Step;

import java.util.List;


public final class DetailStepPagerAdapter extends FragmentStatePagerAdapter {

    private List<Step> mStepList;

    public DetailStepPagerAdapter(FragmentManager fm, List<Step> stepList) {
        super(fm);
        this.mStepList = stepList;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailStepListFragment.newInstance(mStepList.get(position));
    }

    @Override
    public int getCount() {
        if (mStepList == null)
            return 0;

        return mStepList.size();
    }
}
