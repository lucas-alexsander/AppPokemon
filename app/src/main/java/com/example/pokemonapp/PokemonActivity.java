package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pokemonapp.Adapter.MoveAdapter;
import com.example.pokemonapp.Adapter.StatAdapter;
import com.example.pokemonapp.Adapter.TypeAdapter;
import com.example.pokemonapp.Model.MoveModel;
import com.example.pokemonapp.Model.PokemonModel;
import com.example.pokemonapp.Model.StatsModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        TextView pokemonName = (TextView) findViewById(R.id.tvNome);
        ImageView pokemonSprite = (ImageView) findViewById(R.id.ivSprite);

        List<StatsModel> statsModelList = new ArrayList<>();
        RecyclerView rvStats = (RecyclerView) findViewById(R.id.rvStats);
        RecyclerView.Adapter adapterStats = new StatAdapter(statsModelList);
        RecyclerView.LayoutManager layoutManagerStats = new LinearLayoutManager(this);
        rvStats.setAdapter(adapterStats);
        rvStats.setLayoutManager(layoutManagerStats);

        List<MoveModel> movesModelList = new ArrayList<>();
        RecyclerView rvMoves = (RecyclerView) findViewById(R.id.rvModes);
        RecyclerView.Adapter adapterMoves = new MoveAdapter(movesModelList);
        RecyclerView.LayoutManager layoutManagerMoves = new LinearLayoutManager(this);
        rvMoves.setAdapter(adapterMoves);
        rvMoves.setLayoutManager(layoutManagerMoves);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = getIntent().getExtras().getString("url");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject sprites = response.getJSONObject("sprites");
                    JSONObject spritesOther = sprites.getJSONObject("other");
                    JSONObject spritesHome = spritesOther.getJSONObject("home");
                    String spriteURL = spritesHome.getString("front_default");
                    String name = response.getString("name");

                    PokemonModel pokemon = new PokemonModel(name, spriteURL);
                    Picasso.get().load(spriteURL).into(pokemonSprite);
                    pokemonName.setText(pokemon.getName());

                    //STATS
                    JSONArray stats = response.getJSONArray("stats");
                    for(int i = 0; i < stats.length(); i++)
                    {
                        JSONObject stat = stats.getJSONObject(i);
                        int baseStat = stat.getInt("base_stat");
                        int effortStat = stat.getInt("effort");
                        JSONObject statDetail = stat.getJSONObject("stat");
                        String nameStat = statDetail.getString("name");
                        String urlStat = statDetail.getString("url");
                        StatsModel statModel = new StatsModel(baseStat, effortStat, nameStat, urlStat);
                        statsModelList.add(statModel);
                    }

                    //MOVES
                    JSONArray movesResponse = response.getJSONArray("moves");
                    for(int i = 0; i < movesResponse.length(); i++) {
                        JSONObject moveOBJ = movesResponse.getJSONObject(i).getJSONObject("move");
                        String moveName = moveOBJ.getString("name");
                        String moveURL = moveOBJ.getString("url");
                        MoveModel moveModel = new MoveModel(moveName,moveURL);
                        movesModelList.add(moveModel);
                    }

                    adapterStats.notifyDataSetChanged();
                    adapterMoves.notifyDataSetChanged();
                    Log.d("POKEMON",name);
                    } catch (JSONException jsonException) {
                    jsonException.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PokemonActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}