package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.ListeProducteurAdapteur;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;
import java.util.List;

public class ListeProducteursActivity extends AppCompatActivity {

    protected ListView listeProducteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_producteurs);

        listeProducteurs = findViewById(R.id.vue_liste_producteurs_liste_producteurs);
        ListeProducteurAdapteur listeProducteurAdapteur = new ListeProducteurAdapteur(getApplicationContext());
        listeProducteurs.setAdapter(listeProducteurAdapteur);

        List<Productor> listeDesProducteurs = new ArrayList<>();
        Productor productor = new Productor("Jean masse", "13 rue de la soif",
                "0617354683", "8h / 18h", "Ceci est la description", null);
        listeDesProducteurs.add(productor);
        listeDesProducteurs.add(productor);
        listeDesProducteurs.add(productor);

        listeProducteurAdapteur.setProducteurs(listeDesProducteurs);
    }
}