package com.example.localfeeds.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.localfeeds.fragments.AnnouncementsListFragment;
import com.example.localfeeds.fragments.ProductorsListFragment;

public class SampleFragmentPageAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Annonces", "Producteurs" };
    private final int PAGE_COUNT = 2;

    public SampleFragmentPageAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int pagePosition) {
        if (tabTitles[pagePosition].equals("Annonces"))
            return AnnouncementsListFragment.newInstance(pagePosition + 1);
        else
            return ProductorsListFragment.newInstance(pagePosition + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
