package com.example.android.bakeapp.fragments;



import com.example.android.bakeapp.models.Step;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Since using video, I considered the using a FragmentStatePagerAdapter so we don't
 * load videos we havent seen yet.
 */
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
