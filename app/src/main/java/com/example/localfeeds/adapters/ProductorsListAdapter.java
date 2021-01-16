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

public class ProductorsListAdapter extends ArrayAdapter<Productor> {

    public ProductorsListAdapter(@NonNull Context context) {
        super(context, R.layout.liste_producteurs_layout, new ArrayList<>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ProductorsListView productorsListView;

        if (convertView == null)
            productorsListView = new ProductorsListView(getContext());
        else
            productorsListView = (ProductorsListView) convertView;

        Productor producteur = getItem(position);

        productorsListView.populate(producteur);

        return productorsListView;
    }

    public void setProducteurs(List<Productor> producteurs) {

        this.clear();
        this.addAll(producteurs);
    }
}
