package com.another1dd.carhelper.places.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.another1dd.carhelper.FirebaseHandler;
import com.another1dd.carhelper.R;
import com.another1dd.carhelper.places.adapters.ContentAdapter;
import com.another1dd.carhelper.places.javaclasses.Place;
import com.google.firebase.database.DatabaseReference;

public class ServiceStationFragment extends Fragment {


    public ServiceStationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        FirebaseHandler firebaseHandler = new FirebaseHandler(getContext());
        DatabaseReference myRef = firebaseHandler.getServiceStations();
        ContentAdapter adapter = new ContentAdapter(myRef, Place.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }



}
