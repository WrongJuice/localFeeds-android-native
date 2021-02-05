package com.example.localfeeds.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localfeeds.R;

public class IntroActivity extends AppCompatActivity {

    Button boutonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        boutonStart = (Button) findViewById(R.id.firstStartButton);
        boutonStart.setOnClickListener(view -> {
            Intent start_onboarding = new Intent(IntroActivity.this, OnboardActivity.class);
            startActivity(start_onboarding);
            finish();
        });
    }

}
