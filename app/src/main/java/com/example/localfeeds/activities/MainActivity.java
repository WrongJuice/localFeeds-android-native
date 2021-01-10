package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.localfeeds.R;

public class MainActivity extends AppCompatActivity {

    Button boutonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonStart = (Button) findViewById(R.id.firstStartButton);
        boutonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_onboarding = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(start_onboarding);
                finish();
            }
        });
    }

}