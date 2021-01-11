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
        ImageView favoriteIcon = convertView.findViewById(R.id.favorite_icon);


        // Populate the data into the template view using the data object
        productorName.setText(announcement.getIdProductor());
        announcementDescription.setText(announcement.getDescription());
        title.setText(announcement.getId());
        //distance.setText(announcement.getProductor.récupérer sa distance);

        favoriteIcon.setOnClickListener(v -> {
            favoriteIcon.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
        });

        announcementView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailAnnouncementActivity.class);
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
