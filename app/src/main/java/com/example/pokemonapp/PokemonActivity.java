package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.pokemonapp.Model.PokemonModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        TextView pokemonName = (TextView) findViewById(R.id.tvNome);
        ImageView pokemonSprite = (ImageView) findViewById(R.id.ivSprite);

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

                    JSONArray stats = response.getJSONArray("stats");
                    for(int i = 0; i < stats.length(); i++)
                    {
                        JSONObject stat = stats.getJSONObject(i);
                        String base = stat.getString("base_stat");

                    }

                    PokemonModel pokemon = new PokemonModel(name, spriteURL);


                    Picasso.get().load(pokemon.getSprint_url()).into(pokemonSprite);
                    pokemonName.setText(pokemon.getName());


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