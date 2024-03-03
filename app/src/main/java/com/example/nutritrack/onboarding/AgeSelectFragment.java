package com.example.nutritrack.onboarding;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutritrack.Onboarding;
import com.example.nutritrack.R;

import java.util.Calendar;

public class AgeSelectFragment extends Fragment {

    private EditText dobEditText, heightEditText, weightEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_personalize_age, container, false);

        dobEditText = rootView.findViewById(R.id.dobEditText);

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

        Button backButton = rootView.findViewById(R.id.btnGoalBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() instanceof Onboarding) {
                    Onboarding onboarding = (Onboarding) getActivity();
                    onboarding.navigateToPreviousPage();
                }
            }
        });

        dobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        return rootView;
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                R.style.DialogTheme,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                        String selectedDate = selectedDayOfMonth + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        dobEditText.setText(selectedDate);
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }
}
