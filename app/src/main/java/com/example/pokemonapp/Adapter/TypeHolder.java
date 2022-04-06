package com.example.pokemonapp.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TypeHolder extends RecyclerView.ViewHolder {

    public View viewCategory;

    public TypeHolder(@NonNull View itemView) {
        super(itemView);
        this.viewCategory = itemView;
    }
}
