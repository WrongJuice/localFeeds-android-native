package com.example.localfeeds.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.localfeeds.R;
import com.example.localfeeds.models.Productor;

public class VueListeProducteurs extends FrameLayout {

    public VueListeProducteurs(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.liste_producteurs_layout, this);
    }

    @SuppressLint("SetTextI18n")
    public void populate(@NonNull Productor producteur) {

        TextView texteNomProducteur = findViewById(R.id.modele_liste_producteurs_nom_prenom_producteur);
        TextView texteHorairesOuvertures = findViewById(R.id.modele_liste_producteurs_horaires_ouverture);
        TextView texteDescriptionProducteur = findViewById(R.id.modele_liste_producteurs_description);

        ImageView imageProducteur = findViewById(R.id.modele_producteurs_patient_image_producteur);

        texteNomProducteur.setText(producteur.getName());
        texteHorairesOuvertures.setText(producteur.getSchedule());
        texteDescriptionProducteur.setText(producteur.getDesc());

        imageProducteur.setImageResource(R.drawable.ic_baseline_person_24);
    }
}
