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

        //categories.add(new CategoryModel("Legendary"));
        //categories.add(new CategoryModel("Normal"));
        //categories.add(new CategoryModel("Epic"));

        RecyclerView rvtypes = (RecyclerView) findViewById(R.id.svCategories);

        RecyclerView.Adapter adapterTypes = new TypeAdapter(types);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        rvtypes.setAdapter(adapterTypes);
        rvtypes.setLayoutManager(layoutManager);


        //TextView textView = (TextView) findViewById(R.id.tvHome);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/type/";
        //https://pokedevs.gitbook.io/pokedex/resources/categories
        //https://pokeapi.glitch.me/v1/pokemon/greninja
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // now we get our response from API in json object format.
                    // in below line we are extracting a string with its key
                    // value from our json object.
                    // similarly we are extracting all the strings from our json object.
                    //String courseName = response.getString("courseName");
                    JSONArray typesResult = response.getJSONArray("results");
                    for (int i = 0; i < typesResult.length(); i ++
                         ) {
                        String name = typesResult.getJSONObject(i).getString("name");
                        String url = typesResult.getJSONObject(i).getString("url");
                        types.add(new TypeModel(name, url));
                        System.out.println(name);
                    }
                    adapterTypes.notifyDataSetChanged();
                    //textView.setText(category);
                    // we are using picasso to load the image from url.
                    //Picasso.get().load(courseImageURL).into(courseIV);
                } catch (JSONException e) {
                    // if we do not extract data from json object properly.
                    // below line of code is use to handle json exception
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            // this is the error listener method which
            // we will call if we get any error from API.
            @Override
            public void onErrorResponse(VolleyError error) {
                // below line is use to display a toast message along with our error.
                Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }
}