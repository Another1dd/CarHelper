package com.another1dd.carhelper.places.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.another1dd.carhelper.places.javaclasses.Place;
import com.bumptech.glide.Glide;
import com.google.firebase.database.Query;

public class ContentAdapter extends FirebaseRecyclerAdapter<ViewHolder, Place> {
    private Context context;
    // Установим количество элементов списка в RecyclerView.


    public ContentAdapter(Query query, Class<Place> itemClass) {
        super(query, itemClass);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = getItem(position);
        holder.name.setText(place.getName());
        holder.description.setText(place.getAdress());
        String url = place.getImage();

        Glide.with(context)
                .load(url)
                .into(holder.image);


    }

    @Override
    protected void itemAdded(Place item, String key, int position) {

    }

    @Override
    protected void itemChanged(Place oldItem, Place newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Place item, String key, int position) {

    }

    @Override
    protected void itemMoved(Place item, String key, int oldPosition, int newPosition) {

    }
}
