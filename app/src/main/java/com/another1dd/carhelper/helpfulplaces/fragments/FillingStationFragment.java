package com.another1dd.carhelper.helpfulplaces.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.another1dd.carhelper.R;
import com.another1dd.carhelper.helpfulplaces.adapters.FirebaseRecyclerAdapter;
import com.another1dd.carhelper.helpfulplaces.javaclasses.FillingStation;
import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class FillingStationFragment extends Fragment {
    static StorageReference storage;

    public FillingStationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance().getReferenceFromUrl("gs://carhelper-28b00.appspot.com/cities/homel/fillingStations/");
        DatabaseReference myRef = database.getReference("city").child("homel").child("fillingStations");




        ContentAdapter adapter = new ContentAdapter(myRef, FillingStation.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }

    public class ContentAdapter extends FirebaseRecyclerAdapter<ViewHolder, FillingStation> {
        // Установим количество элементов списка в RecyclerView.


        public ContentAdapter(Query query, Class<FillingStation> itemClass) {
            super(query, itemClass);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            FillingStation fillingStation = getItem(position);
            holder.name.setText(fillingStation.getName());
            holder.description.setText(fillingStation.getText());
            Long id = fillingStation.getId();
            String sId = id.toString()+".jpg";
            StorageReference imgRef = storage.child(sId);

            Glide.with(getContext())
                    .using(new FirebaseImageLoader())
                    .load(imgRef)
                    .into(holder.image);


        }

        @Override
        protected void itemAdded(FillingStation item, String key, int position) {

        }

        @Override
        protected void itemChanged(FillingStation oldItem, FillingStation newItem, String key, int position) {

        }

        @Override
        protected void itemRemoved(FillingStation item, String key, int position) {

        }

        @Override
        protected void itemMoved(FillingStation item, String key, int oldPosition, int newPosition) {

        }


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        ImageView image;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_filling_station, parent, false));
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            image = (ImageView) itemView.findViewById(R.id.card_image);
        }
    }

}
