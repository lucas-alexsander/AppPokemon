package com.example.pokemonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.Model.CategoryModel;
import com.example.pokemonapp.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {


    private List<CategoryModel> categories;

    public CategoryAdapter(List<CategoryModel> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,  parent, false);
        CategoryHolder cHolder = new CategoryHolder(v);

        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        TextView tvTitulo = holder.viewCategory.findViewById(R.id.tvTitulo);
        tvTitulo.setText(categories.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
