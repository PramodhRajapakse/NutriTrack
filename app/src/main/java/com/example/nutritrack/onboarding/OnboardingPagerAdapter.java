package com.example.nutritrack.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

// OnboardingPagerAdapter.java
public class OnboardingPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 3;

    public OnboardingPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GoalSelectFragment();
            case 1:
                return new GenderSelectFragment();
            case 2:
                return new AgeSelectFragment();
            default:
                return new GoalSelectFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    public void nextPage(ViewPager viewPager) {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem < getCount() - 1) {
            viewPager.setCurrentItem(currentItem + 1);
        }
    }

    public void previousPage(ViewPager viewPager) {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem > 0) {
            viewPager.setCurrentItem(currentItem - 1);
        }
    }
}

