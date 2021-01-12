package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localfeeds.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class PreferenceActivity extends AppCompatActivity {

    Switch boutonSwitch;
    Button boutonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        boutonSwitch = findViewById(R.id.switchVege);
        boutonConfirm = findViewById(R.id.boutonConfirmerPreference);

        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        boutonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean(getString(R.string.is_vegetarien), boutonSwitch.isChecked());
                editor.apply();

                Intent intentionNaviguerListeProducteurs = new Intent(PreferenceActivity.this, ListeProducteursActivity.class);
                startActivity(intentionNaviguerListeProducteurs);
            }
        });
    }


}