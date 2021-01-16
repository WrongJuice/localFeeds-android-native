package com.example.localfeeds.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.AnnouncementAdapter;
import com.example.localfeeds.datas.AnnouncementService;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;

public class AnnouncementsListActivity extends AppCompatActivity {

    private AnnouncementAdapter announcementAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements_list);
        listView = findViewById(R.id.announcement_list);

        // NEED TO BE CLEANED
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        boolean isVegetarien = pref.getBoolean(getString(R.string.is_vegetarien), false);
        ArrayList<Productor> listeDesProducteurs = new ProductorService().getProductors();


        if (isVegetarien) {
            for (Productor aProductor : listeDesProducteurs)
                if (!aProductor.containsSomethingElseThan(Product.Viande)) aProductor.undisplay();
        } else { // If I unselect the vegetarien option
            for (Productor aProductor : listeDesProducteurs) aProductor.display();
        }

        // NEED CLEANING
        AnnouncementService announcementService = new AnnouncementService();
        announcementAdapter = new AnnouncementAdapter(this, announcementService.getAnnouncements());
        listView.setAdapter(announcementAdapter);
    }
}
