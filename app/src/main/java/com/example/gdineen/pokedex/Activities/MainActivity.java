package com.example.gdineen.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gdineen.pokedex.Adapters.PokemonListItemAdapter;
import com.example.gdineen.pokedex.DataManager.PokemonDataManager;
import com.example.gdineen.pokedex.R;

public class MainActivity extends AppCompatActivity {

    //RecyclerView
    RecyclerView recyclerView;
    PokemonListItemAdapter pokemonListItemAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get data
        PokemonDataManager pokemonDataManager = PokemonDataManager.getInstance(this);

        //setup recyclerview
        recyclerView = findViewById(R.id.mainrecyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pokemonListItemAdapter = new PokemonListItemAdapter(pokemonDataManager.getAllPokemon());
        recyclerView.setAdapter(pokemonListItemAdapter);
    }
}
