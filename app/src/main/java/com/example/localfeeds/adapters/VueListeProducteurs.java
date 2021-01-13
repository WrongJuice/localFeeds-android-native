package com.example.localfeeds.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.localfeeds.R;
import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;

public class VueListeProducteurs extends FrameLayout {

    static boolean test = true;

    public VueListeProducteurs(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.liste_producteurs_layout, this);
    }

    @SuppressLint("SetTextI18n")
    public void populate(@NonNull Productor producteur) {

        TextView texteNomProducteur = findViewById(R.id.modele_liste_producteurs_nom_prenom_producteur);
        TextView texteHorairesOuvertures = findViewById(R.id.modele_liste_producteurs_horaires_ouverture);

        ImageView imageProducteur = findViewById(R.id.modele_producteurs_patient_image_producteur);

        ImageView favoriteButton = findViewById(R.id.add_favorite_icon);

        ImageView vegetablesIcon = findViewById(R.id.modele_liste_producteur_logo_vegetable);
        ImageView fruitsIcon = findViewById(R.id.modele_liste_producteur_logo_fruits);
        ImageView eggsIcon = findViewById(R.id.modele_liste_producteur_logo_egg);
        ImageView milkIcon = findViewById(R.id.modele_liste_producteur_logo_milk);
        ImageView meatIcon = findViewById(R.id.modele_liste_producteur_logo_meat);

        ArrayList<Product> productsList = producteur.getTypeProduit();

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

        favoriteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (test) {

                    favoriteButton.setImageResource(R.drawable.ic_love_color);
                    test = false;
                }
                else {

                    favoriteButton.setImageResource(R.drawable.ic_love);
                    test = true;
                }
            }
        });

        texteNomProducteur.setText(producteur.getName());
        texteHorairesOuvertures.setText(producteur.getSchedule());

        Context context = imageProducteur.getContext();
        System.out.println(producteur.getImage());
        int id = context.getResources().getIdentifier(producteur.getImage(), "drawable", context.getPackageName());
        imageProducteur.setImageResource(id);
    }
}
