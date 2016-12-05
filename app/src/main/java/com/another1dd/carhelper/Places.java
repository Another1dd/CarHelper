package com.another1dd.carhelper;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.another1dd.carhelper.helpfulplaces.Fragments.CarWashFragment;
import com.another1dd.carhelper.helpfulplaces.Fragments.FillingStationFragment;
import com.another1dd.carhelper.helpfulplaces.Fragments.ServiceStationFragment;


public class Places extends Fragment {

    public  TabLayout tabLayout;
    public  ViewPager viewPager;
    public static int int_items = 3;

    public Places() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_places, null);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ActionBar supportActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        return view;
    }


    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new FillingStationFragment();
                case 1 : return new CarWashFragment();
                case 2 : return new ServiceStationFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "AZS";
                case 1 :
                    return "CarWash";
                case 2 :
                    return "STO";
            }
            return null;
        }
    }


}
