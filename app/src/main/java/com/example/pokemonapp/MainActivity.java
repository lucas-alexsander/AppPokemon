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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pokemonapp.Adapter.TypeAdapter;
import com.example.pokemonapp.Model.CategoryModel;
import com.example.pokemonapp.Model.TypeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TypeModel> types = new ArrayList<>();

        RecyclerView rvtypes = (RecyclerView) findViewById(R.id.svCategories);

        RecyclerView.Adapter adapterTypes = new TypeAdapter(types);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvtypes.setAdapter(adapterTypes);
        rvtypes.setLayoutManager(layoutManager);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/type/";
        //https://pokedevs.gitbook.io/pokedex/resources/categories
        //https://pokeapi.glitch.me/v1/pokemon/greninja
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray typesResult = response.getJSONArray("results");
                    for (int i = 0; i < typesResult.length(); i ++
                         ) {
                        String name = typesResult.getJSONObject(i).getString("name");
                        String url = typesResult.getJSONObject(i).getString("url");
                        types.add(new TypeModel(name, url));
//                        System.out.println(name);
                    }
                    adapterTypes.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}