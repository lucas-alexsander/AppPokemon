package com.example.pokemonapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.Model.PokemonModel;
import com.example.pokemonapp.PokemonsActivity;
import com.example.pokemonapp.R;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<Holder> {

    private List<PokemonModel> pokemons;

    public PokemonAdapter(List<PokemonModel> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pokemom,  parent, false);
        Holder cHolder = new Holder(v);

        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TextView tvTitulo = holder.viewCategory.findViewById(R.id.tvName);
        tvTitulo.setText(pokemons.get(position).getName());
        View layout = holder.viewCategory.findViewById(R.id.ltType);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PokemonsActivity.class);
                String url = pokemons.get(holder.getAdapterPosition()).getUrl();
                intent.putExtra("url", url);
                System.out.println(url);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
