package com.example.localfeeds.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.localfeeds.R;
import com.example.localfeeds.activities.AnnouncementsListActivity;
import com.example.localfeeds.activities.DetailAnnouncementActivity;
import com.example.localfeeds.activities.MainActivity;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Announcement;

import java.util.ArrayList;

public class AnnouncementAdapter extends ArrayAdapter<Announcement> {

    Context context;

    public AnnouncementAdapter(Context context, ArrayList<Announcement> announcements) {
        super(context, 0, announcements);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Announcement announcement = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_announcement, parent, false);
        }

        // Lookup view for data population
        TextView productorName = convertView.findViewById(R.id.productor_name);
        TextView announcementDescription = convertView.findViewById(R.id.description);
        TextView title = convertView.findViewById(R.id.title);
        TextView distance = convertView.findViewById(R.id.distance);
        LinearLayout announcementView = convertView.findViewById(R.id.announcement_view);

        //NEED TO BE SOLVED
        ProductorService productorService = new ProductorService();

        // Populate the data into the template view using the data object
        productorName.setText(productorService.getProductorById(announcement.getIdProductor()).getName());
        announcementDescription.setText(announcement.getDescription());
        title.setText(announcement.getTitle());
        //distance.setText(announcement.getProductor.récupérer sa distance);

        announcementView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailAnnouncementActivity.class);
            intent.putExtra("announcement_title", announcement.getTitle());
            intent.putExtra("announcement_desc", announcement.getDescription());
            context.startActivity(intent);
        });

        // Return the completed view to render on screen
        return convertView;
    }

    @Nullable
    @Override
    public Announcement getItem(int position) {
        return super.getItem(position);
    }

}
