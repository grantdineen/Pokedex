package com.example.gdineen.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gdineen.pokedex.DataManager.PokemonDataManager;
import com.example.gdineen.pokedex.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PokemonDataManager pokemonDataManager = PokemonDataManager.getInstance(this);
    }
}
