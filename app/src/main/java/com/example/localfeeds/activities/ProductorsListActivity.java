package com.example.localfeeds.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.ListeProducteurAdapteur;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;

public class ProductorsListActivity extends AppCompatActivity {

    protected ListView listeProducteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_producteurs);

        listeProducteurs = findViewById(R.id.vue_liste_producteurs_liste_producteurs);

        // NEED TO BE CLEANED
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        boolean isVegetarien = pref.getBoolean(getString(R.string.is_vegetarien), false);
        ArrayList<Productor> listeDesProducteurs = new ProductorService().getProductors();

        if (isVegetarien) {
            for (Productor aProductor : listeDesProducteurs) {
                if (!aProductor.containsSomethingElseThan(Product.Viande))
                    aProductor.undisplay();
            }
        }

        listeProducteurs.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intentionNaviguerInformationProducteur = new Intent(ProductorsListActivity.this, ProductorInformationsActivity.class);
            intentionNaviguerInformationProducteur.putExtra("id_producteur", listeDesProducteurs.get(i).getId());
            startActivity(intentionNaviguerInformationProducteur);
        });

        System.out.println("ALED " + listeDesProducteurs.toString());

        ListeProducteurAdapteur listeProducteurAdapteur = new ListeProducteurAdapteur(getApplicationContext());
        listeProducteurAdapteur.setProducteurs(listeDesProducteurs);
        listeProducteurs.setAdapter(listeProducteurAdapteur);
    }
}