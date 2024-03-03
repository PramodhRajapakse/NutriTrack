package com.example.nutritrack.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nutritrack.Onboarding;
import com.example.nutritrack.R;

public class GoalSelectFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_personalize_goal, container, false);

        Button nextButton = rootView.findViewById(R.id.btnGoalNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the next fragment
                if (getActivity() instanceof Onboarding) {
                    Onboarding onboarding = (Onboarding) getActivity();
                    onboarding.navigateToNextPage();
                }
            }
        });

       return rootView;
    }

}
