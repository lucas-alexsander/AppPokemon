package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pokemonapp.Adapter.CategoryAdapter;
import com.example.pokemonapp.Model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<CategoryModel> categories = new ArrayList<>();

        categories.add(new CategoryModel("Legendary"));
        categories.add(new CategoryModel("Normal"));
        categories.add(new CategoryModel("Epic"));

        RecyclerView rvCaterogies = (RecyclerView) findViewById(R.id.svCategories);

        RecyclerView.Adapter adapterCategories = new CategoryAdapter(categories);

    }
}