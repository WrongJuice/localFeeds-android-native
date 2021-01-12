package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.SlideAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout dotsLayout;
    private SlideAdapter slideAdapter;
    Button boutonDebut;

    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        boutonDebut = (Button) findViewById(R.id.buttonStartApp);
        boutonDebut.setEnabled(false);

        slideAdapter = new SlideAdapter(this);
        slideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

        boutonDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(IntroActivity.this, PreferenceActivity.class);
                startActivity(main_activity);
                finish();
            }
        });
    }

    public void addDotsIndicator(int position) {
        dots = new TextView[3];

        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.purple_200));
        }

        if (position == 2) {
            boutonDebut.setEnabled(true);
        } else {
            boutonDebut.setEnabled(false);
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };




}