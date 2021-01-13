package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.ListeProducteurAdapteur;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Product;
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

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        boolean isVegetarien = pref.getBoolean(getString(R.string.is_vegetarien), false);

        List<Productor> listeDesProducteurs = new ProductorService().getProductors();

        if (isVegetarien) {

            for (int i = 0; i < listeDesProducteurs.size(); i++) {

                if (listeDesProducteurs.get(i).getTypeProduit().contains(Product.Viande))
                    listeDesProducteurs.remove(i);
            }
        }

        listeProducteurs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intentionNaviguerInformationProducteur = new Intent(ListeProducteursActivity.this, InformationProducteur.class);
                intentionNaviguerInformationProducteur.putExtra("id_producteur", listeDesProducteurs.get(i).getId());
                startActivity(intentionNaviguerInformationProducteur);
            }
        });

        listeProducteurAdapteur.setProducteurs(listeDesProducteurs);
    }
}