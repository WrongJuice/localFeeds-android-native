package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.SampleFragmentPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getSharedPreferences("MyPref", Context.MODE_PRIVATE).getBoolean("intro", false)) {
            System.out.println("intro");
            Intent intro = new Intent(MainActivity.this, IntroActivity.class);
            startActivity(intro);
            finish();
        }

        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPageAdapter(getSupportFragmentManager(),
                R.layout.activity_main));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}