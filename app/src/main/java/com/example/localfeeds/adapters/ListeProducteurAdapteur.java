package com.example.localfeeds.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.localfeeds.R;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;
import java.util.List;

public class ListeProducteurAdapteur extends ArrayAdapter<Productor> {

    public ListeProducteurAdapteur(@NonNull Context context) {
        super(context, R.layout.liste_producteurs_layout, new ArrayList<Productor>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        VueListeProducteurs vueListeProducteurs;

        if (convertView == null)
            vueListeProducteurs = new VueListeProducteurs(getContext());
        else
            vueListeProducteurs = (VueListeProducteurs) convertView;

        Productor producteur = getItem(position);

        vueListeProducteurs.populate(producteur);

        return vueListeProducteurs;
    }

    public void setProducteurs(List<Productor> producteurs) {

        this.clear();
        this.addAll(producteurs);
    }
}
