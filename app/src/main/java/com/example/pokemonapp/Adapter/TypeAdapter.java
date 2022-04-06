package com.example.pokemonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.Model.CategoryModel;
import com.example.pokemonapp.Model.TypeModel;
import com.example.pokemonapp.R;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeHolder> {


    private List<TypeModel> types;

    public TypeAdapter(List<TypeModel> types) {
        this.types = types;
    }

    @NonNull
    @Override
    public TypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,  parent, false);
        TypeHolder cHolder = new TypeHolder(v);

        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TypeHolder holder, int position) {

        TextView tvTitulo = holder.viewCategory.findViewById(R.id.tvName);
        tvTitulo.setText(types.get(position).getName());
        ImageView imageView = holder.viewCategory.findViewById(R.id.ltType);
        imageView.setOnClickListener(view -> {

        });

    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
