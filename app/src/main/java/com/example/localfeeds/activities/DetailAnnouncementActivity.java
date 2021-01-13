package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.localfeeds.R;

public class DetailAnnouncementActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_announcement);
        titleTextView = findViewById(R.id.title);
        descriptionTextView = findViewById(R.id.description);
        titleTextView.setText(getIntent().getStringExtra("announcement_title"));
        descriptionTextView.setText(getIntent().getStringExtra("announcement_desc"));
    }
}