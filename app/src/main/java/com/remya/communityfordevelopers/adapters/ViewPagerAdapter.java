package com.remya.communityfordevelopers.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.remya.communityfordevelopers.fragments.FirstOnboardingFragment;
import com.remya.communityfordevelopers.fragments.FourthOnboardingFragment;
import com.remya.communityfordevelopers.fragments.SecondOnboardingFragment;
import com.remya.communityfordevelopers.fragments.ThirdOnboardingFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new FirstOnboardingFragment();
            case 1: return new SecondOnboardingFragment();
            case 2: return new ThirdOnboardingFragment();
            case 3: return new FourthOnboardingFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
