package com.example.pokemonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.Model.MoveModel;
import com.example.pokemonapp.R;

import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<Holder> {


    List<MoveModel> moves;

    public MoveAdapter(List<MoveModel> moves) {
        this.moves = moves;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_move,  parent, false);
        Holder cHolder = new Holder(v);

        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TextView tvMoveName = holder.viewCategory.findViewById(R.id.tvMoveName);

        tvMoveName.setText(moves.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return moves.size();
    }
}
