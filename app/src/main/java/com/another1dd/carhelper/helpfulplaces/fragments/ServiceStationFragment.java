package com.another1dd.carhelper.helpfulplaces.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.another1dd.carhelper.R;
import com.another1dd.carhelper.helpfulplaces.adapters.FirebaseRecyclerAdapter;
import com.another1dd.carhelper.helpfulplaces.javaclasses.ServiceStation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceStationFragment extends Fragment {


    public ServiceStationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ServiceStation");
        ContentAdapter adapter = new ContentAdapter(myRef, ServiceStation.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }

    public static class ContentAdapter extends FirebaseRecyclerAdapter<ViewHolder, ServiceStation> {
        // Установим количество элементов списка в RecyclerView.


        public ContentAdapter(Query query, Class<ServiceStation> itemClass) {
            super(query, itemClass);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ServiceStation serviceStation = getItem(position);
            holder.name.setText(serviceStation.getName());
            holder.description.setText(serviceStation.getText());
        }

        @Override
        protected void itemAdded(ServiceStation item, String key, int position) {

        }

        @Override
        protected void itemChanged(ServiceStation oldItem, ServiceStation newItem, String key, int position) {

        }

        @Override
        protected void itemRemoved(ServiceStation item, String key, int position) {

        }

        @Override
        protected void itemMoved(ServiceStation item, String key, int oldPosition, int newPosition) {

        }


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_service_station, parent, false));
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
        }
    }

}
