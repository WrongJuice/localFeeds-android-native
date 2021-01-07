package com.example.localfeeds.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.localfeeds.R;

import java.util.ArrayList;

public class ListeProducteurAdapteur extends ArrayAdapter<Producteur> {

    public ListeProducteurAdapteur(@NonNull Context context) {
        super(context, R.layout.liste_producteurs_layout, new ArrayList<Producteur>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        VueListeProducteurs vueListeProducteurs;

        if (convertView == null)
            vueListeProducteurs = new VueListeProducteurs(getContext());
        else
            vueListeProducteurs = (VueListeProducteurs) convertView;

        Producteur producteur = getItem(position);

        vueListeProducteurs.populate(producteur);

        return vueListeProducteurs;
    }

    public void setProducteurs(List<Producteur> producteurs) {

        this.clear();
        this.addAll(producteurs);
    }
}
