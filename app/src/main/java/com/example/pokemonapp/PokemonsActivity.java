package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pokemonapp.Adapter.PokemonAdapter;
import com.example.pokemonapp.Model.PokemonModel;
import com.example.pokemonapp.Model.TypeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PokemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        List<PokemonModel> pokemons = new ArrayList<>();

        RecyclerView rvPokemons = (RecyclerView) findViewById(R.id.rvPokemons);

        RecyclerView.Adapter adapterPokemons = new PokemonAdapter(pokemons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvPokemons.setAdapter(adapterPokemons);
        rvPokemons.setLayoutManager(layoutManager);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = getIntent().getExtras().getString("url");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray pokemonsResult = response.getJSONArray("pokemon");
                    for (int i = 0; i < pokemonsResult.length(); i ++
                    ) {
                        JSONObject pokemonObject = pokemonsResult.getJSONObject(i).getJSONObject("pokemon");
                        String name = pokemonObject.getString("name");
                        String url = pokemonObject.getString("url");
                        pokemons.add(new PokemonModel(name, url));
                        System.out.println(name);
                    }
                    adapterPokemons.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PokemonsActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}