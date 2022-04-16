package com.example.pokemonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.Model.StatsModel;
import com.example.pokemonapp.R;

import java.util.List;

public class StatAdapter extends RecyclerView.Adapter<Holder> {


    private List<StatsModel> stats;

    public StatAdapter(List<StatsModel> stats) {
        this.stats = stats;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_stat,  parent, false);
        Holder cHolder = new Holder(v);

        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TextView tvStatName = holder.viewCategory.findViewById(R.id.tvStatName);
        TextView tvStatValue= holder.viewCategory.findViewById(R.id.tvStatValue);

        tvStatName.setText(stats.get(position).getName());
        tvStatValue.setText(String.valueOf(stats.get(position).getBase_stat()));
    }

    @Override
    public int getItemCount() {
        return stats.size();
    }
}
