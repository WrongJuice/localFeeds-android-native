package com.example.localfeeds.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.localfeeds.R;
import com.example.localfeeds.activities.ProductorInformationsActivity;
import com.example.localfeeds.adapters.ProductorsListAdapter;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;

public class ProductorsListFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    protected ListView listeProducteurs;

    public static ProductorsListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ProductorsListFragment fragment = new ProductorsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_liste_producteurs, container, false);

        listeProducteurs = view.findViewById(R.id.vue_liste_producteurs_liste_producteurs);

        // NEED TO BE CLEANED
        SharedPreferences pref = view.getContext().getSharedPreferences("MyPref", 0);
        boolean isVegetarien = pref.getBoolean(getString(R.string.is_vegetarien), false);
        ArrayList<Productor> listeDesProducteurs = new ProductorService().getProductors();

        if (isVegetarien) {
            for (Productor aProductor : listeDesProducteurs)
                if (!aProductor.containsSomethingElseThan(Product.Viande)) aProductor.undisplay();
        } else { // If I unselect the vegetarien option
            for (Productor aProductor : listeDesProducteurs) aProductor.display();
        }

        listeProducteurs.setOnItemClickListener((adapterView, v, i, l) -> {
            Intent intentionNaviguerInformationProducteur = new Intent(view.getContext(), ProductorInformationsActivity.class);
            intentionNaviguerInformationProducteur.putExtra("id_producteur", listeDesProducteurs.get(i).getId());
            startActivity(intentionNaviguerInformationProducteur);
        });

        System.out.println("ALED " + listeDesProducteurs.toString());

        ProductorsListAdapter productorsListAdapter = new ProductorsListAdapter(view.getContext());
        productorsListAdapter.setProducteurs(listeDesProducteurs);
        listeProducteurs.setAdapter(productorsListAdapter);


        return view;
    }

}
