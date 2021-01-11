package com.example.localfeeds.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.AnnouncementAdapter;
import com.example.localfeeds.models.Announcement;

import java.util.ArrayList;

public class AnnouncementsListActivity extends AppCompatActivity {

    private AnnouncementAdapter announcementAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements_list);
        ArrayList<Announcement> announcements = new ArrayList<>();
        Announcement tempAnnounc = new Announcement("Titre", "Nom producteur", "description");
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        announcements.add(tempAnnounc);
        System.out.println("size = " + announcements.size());
        announcementAdapter = new AnnouncementAdapter(this, announcements);
        listView = findViewById(R.id.announcement_list);
        listView.setAdapter(announcementAdapter);

    }
}
