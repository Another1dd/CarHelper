package com.another1dd.carhelper.places.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.another1dd.carhelper.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView description;
    ImageView image;

    public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.fragment_place, parent, false));
        name = (TextView) itemView.findViewById(R.id.card_title);
        description = (TextView) itemView.findViewById(R.id.card_text);
        image = (ImageView) itemView.findViewById(R.id.card_image);
    }
}
