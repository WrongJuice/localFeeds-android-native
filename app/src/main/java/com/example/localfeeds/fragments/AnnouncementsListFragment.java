package com.example.localfeeds.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.localfeeds.R;
import com.example.localfeeds.adapters.AnnouncementAdapter;
import com.example.localfeeds.datas.AnnouncementService;
import com.example.localfeeds.datas.ProductorService;
import com.example.localfeeds.models.Product;
import com.example.localfeeds.models.Productor;

import java.util.ArrayList;

public class AnnouncementsListFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private AnnouncementAdapter announcementAdapter;
    private ListView listView;
    private int mPage;

    public static AnnouncementsListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AnnouncementsListFragment fragment = new AnnouncementsListFragment();
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
        View view = inflater.inflate(R.layout.activity_announcements_list, container, false);
        listView = view.findViewById(R.id.announcement_list);

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

        // NEED CLEANING
        AnnouncementService announcementService = new AnnouncementService();
        announcementAdapter = new AnnouncementAdapter(view.getContext(), announcementService.getAnnouncements());
        listView.setAdapter(announcementAdapter);
        return view;
    }

}
