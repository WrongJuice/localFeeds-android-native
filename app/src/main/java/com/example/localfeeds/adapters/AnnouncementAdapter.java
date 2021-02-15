package com.example.localfeeds.adapters;

import android.annotation.SuppressLint;
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
import com.example.localfeeds.activities.DetailAnnouncementActivity;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Announcement;
import com.example.localfeeds.models.Product;

import java.util.ArrayList;

public class AnnouncementAdapter extends ArrayAdapter<Announcement> {

    private Context context;
    private LinearLayout announcementView;

    public AnnouncementAdapter(Context context, ArrayList<Announcement> announcements) {
        super(context, R.layout.layout_announcement, announcements);
        this.context = context;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout announcementView;

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
        announcementView = convertView.findViewById(R.id.announcement_view);

        //NEED TO BE CLEANED
        ProductorService productorService = new ProductorService();
        if (!productorService.getProductorById(announcement.getIdProductor()).isDisplayed()){
            return LayoutInflater.from(getContext()).inflate(R.layout.null_item, null);
        }

        // Populate the data into the template view using the data object
        productorName.setText(productorService.getProductorById(announcement.getIdProductor()).getName());
        announcementDescription.setText(announcement.getDescription());
        title.setText(announcement.getTitle());
        //distance.setText(announcement.getProductor.récupérer sa distance);

        //icons
        ImageView vegetablesIcon = convertView.findViewById(R.id.modele_liste_producteur_logo_vegetable);
        ImageView fruitsIcon = convertView.findViewById(R.id.modele_liste_producteur_logo_fruits);
        ImageView eggsIcon = convertView.findViewById(R.id.modele_liste_producteur_logo_egg);
        ImageView milkIcon = convertView.findViewById(R.id.modele_liste_producteur_logo_milk);
        ImageView meatIcon = convertView.findViewById(R.id.modele_liste_producteur_logo_meat);

        ArrayList<Product> productsList = productorService.getProductorById(announcement.getIdProductor()).getTypeProduit();

        if (productsList.contains(Product.Fruit))
            fruitsIcon.setImageResource(R.drawable.ic_fruits_color);
        if (productsList.contains(Product.Viande))
            meatIcon.setImageResource(R.drawable.ic_meat_color);
        if (productsList.contains(Product.Legume))
            vegetablesIcon.setImageResource(R.drawable.ic_vegetable_color);
        if (productsList.contains(Product.Laitage))
            milkIcon.setImageResource(R.drawable.ic_milk_color);
        if (productsList.contains(Product.Autre))
            eggsIcon.setImageResource(R.drawable.ic_eggs_color);

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
