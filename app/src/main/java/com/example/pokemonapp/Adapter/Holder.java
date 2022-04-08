package com.example.pokemonapp.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    public View viewCategory;

    public Holder(@NonNull View itemView) {
        super(itemView);
        this.viewCategory = itemView;
    }
}
