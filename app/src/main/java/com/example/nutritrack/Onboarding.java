package com.example.nutritrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.nutritrack.onboarding.OnboardingPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Onboarding extends AppCompatActivity {

    private ViewPager viewPager;
    private OnboardingPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);
        adapter = new OnboardingPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public void navigateToNextPage() {
        adapter.nextPage(viewPager);
    }

    // Method to navigate to the previous page from the hosting activity
    public void navigateToPreviousPage() {
        adapter.previousPage(viewPager);
    }

    @Override
    public void onBackPressed() {
        // Override back button behavior to navigate to the previous page
        super.onBackPressed();
        navigateToPreviousPage();
    }

}