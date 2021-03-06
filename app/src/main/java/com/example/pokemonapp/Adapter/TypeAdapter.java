package com.example.pokemonapp.Adapter;

import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.model.TypeModel;
import com.example.pokemonapp.PokemonsActivity;
import com.example.pokemonapp.R;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<Holder> {


    private List<TypeModel> types;

    public TypeAdapter(List<TypeModel> types) {
        this.types = types;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,  parent, false);
        Holder cHolder = new Holder(v);

        return cHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        TextView tvTitulo = holder.viewCategory.findViewById(R.id.tvName);
        tvTitulo.setText(types.get(position).getName());
        View imageView = holder.viewCategory.findViewById(R.id.ltType);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonsActivity.class);
                String url = types.get(holder.getAdapterPosition()).getUrl();
                intent.putExtra("url", url);
                System.out.println(url);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
