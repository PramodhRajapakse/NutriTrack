package com.example.nutritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nutritrack.databinding.ActivityCreateAccountBinding;
import com.example.nutritrack.databinding.ActivityLoginBinding;

public class CreateAccount extends AppCompatActivity {

    ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccount.this, Welcome.class));
                finish();
            }
        });

        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccount.this, Onboarding.class));
                finish();
            }
        });
    }
}