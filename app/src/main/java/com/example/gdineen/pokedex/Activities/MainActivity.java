package com.example.gdineen.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.gdineen.pokedex.Adapters.PokemonListItemAdapter;
import com.example.gdineen.pokedex.Managers.PokemonDataManager;
import com.example.gdineen.pokedex.Managers.SoundManager;
import com.example.gdineen.pokedex.Models.Pokemon;
import com.example.gdineen.pokedex.R;

public class MainActivity extends AppCompatActivity {

    //Toolbar
    Toolbar toolbar;

    //Managers
    PokemonDataManager pokemonDataManager;
    SoundManager soundManager;

    //RecyclerView
    RecyclerView recyclerView;
    PokemonListItemAdapter pokemonListItemAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.pokedex);

        //get data
        pokemonDataManager = PokemonDataManager.getInstance(this);
        //init soundmanager
        soundManager = SoundManager.getInstance(this);

        //setup recyclerview
        recyclerView = findViewById(R.id.mainrecyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pokemonListItemAdapter = new PokemonListItemAdapter(pokemonDataManager.getAllPokemon());
        pokemonListItemAdapter.setOnItemClickListener(new PokemonListItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Pokemon selectedPokemon = pokemonDataManager.getAllPokemon().get(position);

                soundManager.playClickSoundEffect();
                Intent intent = new Intent(getApplicationContext(), PokemonActivity.class);
                intent.putExtra("pokemon", selectedPokemon);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(pokemonListItemAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        soundManager.playMusic();
    }

    @Override
    public void onPause(){
        super.onPause();
        soundManager.stopMusic();
    }

    //create options for toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sorting_menu, menu);
        return true;
    }

    //on toolbar option selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        soundManager.playClickSoundEffect();
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sort_id_option:
                pokemonDataManager.sortById();
                pokemonListItemAdapter.notifyDataSetChanged();
                return true;
            case R.id.sort_name_option:
                pokemonDataManager.sortByName();
                pokemonListItemAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
