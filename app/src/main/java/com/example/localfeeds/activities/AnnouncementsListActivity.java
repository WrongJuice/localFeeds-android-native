package com.example.localfeeds.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.AnnouncementAdapter;
import com.example.localfeeds.datas.AnnouncementService;
import com.example.localfeeds.models.Announcement;

import java.util.ArrayList;

public class AnnouncementsListActivity extends AppCompatActivity {

    private AnnouncementAdapter announcementAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements_list);
        AnnouncementService announcementService = new AnnouncementService();
        announcementAdapter = new AnnouncementAdapter(this, announcementService.getAnnouncements());
        listView = findViewById(R.id.announcement_list);
        listView.setAdapter(announcementAdapter);

    }
}
