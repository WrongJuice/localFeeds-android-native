package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.ListeProducteurAdapteur;

public class ListeProducteursActivity extends AppCompatActivity {

    protected ListView listeProducteurs;
    private static ListeProducteurAdapteur listeProducteurAdapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_producteurs);

        listeProducteurs = findViewById(R.id.vue_liste_producteurs_liste_producteurs);
        listeProducteurAdapteur = new ListeProducteurAdapteur(getApplicationContext());
        listeProducteurs.setAdapter(listeProducteurAdapteur);

    }
}