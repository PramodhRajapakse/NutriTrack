package com.example.nutritrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nutritrack.databinding.ActivityWelcomeBinding;

public class Welcome extends AppCompatActivity {
    private ActivityWelcomeBinding welcomeBinding;
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcomeBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(welcomeBinding.getRoot());

        prefs = getSharedPreferences("recylcopref", MODE_PRIVATE);

        if(prefs.getBoolean("firstrun", true)) {
            Log.d("myTag", prefs.getBoolean("firstRun", true) == true? "true": "false");
            prefs.edit().putBoolean("firstrun", false).commit();
            startActivity(new Intent(Welcome.this , MainActivity.class));
            finish();
        }

        if(prefs.getString("api_token", "") != null && !prefs.getString("api_token", "").trim().isEmpty()){
            startActivity(new Intent(Welcome.this , MainActivity.class));
            finish();
        }

        welcomeBinding.createAccntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, CreateAccount.class));
            }
        });

        welcomeBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Login.class));
            }
        });
    }
}