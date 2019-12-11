package com.example.gdineen.pokedex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdineen.pokedex.Models.Pokemon;
import com.example.gdineen.pokedex.Models.Type;
import com.example.gdineen.pokedex.R;

import java.io.InputStream;
import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity {

    Toolbar toolbar;
    Pokemon selectedPokemon;
    ImageView pokemonImage;
    TextView pokemonTitleTextView;
    TextView hpTextView, speedTextView,
             attackTextView, defenseTextView,
             spAttackTextView, spDefenseTextView;
    View typeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        //get the selected pokemon
        selectedPokemon = (Pokemon)getIntent().getSerializableExtra("pokemon");

        toolbar = findViewById(R.id.pokemontoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(selectedPokemon.getEnglishName());

        //find the views
        pokemonImage = findViewById(R.id.pokemonImage);
        typeView = findViewById(R.id.pokemonTypeView);
        pokemonTitleTextView = findViewById(R.id.pokemonTitleTextView);
        hpTextView = findViewById(R.id.hpTextView);
        speedTextView = findViewById(R.id.speedTextView);
        attackTextView = findViewById(R.id.attackTextView);
        defenseTextView = findViewById(R.id.defenseTextView);
        spAttackTextView = findViewById(R.id.spAttackTextView);
        spDefenseTextView = findViewById(R.id.spDefenseTextView);

        SetPokemonFields();
    }

    private void SetPokemonFields(){
        //set the image
        try{
            InputStream ims = getAssets().open(selectedPokemon.getImagePath());
            Bitmap bitmapSprite = BitmapFactory.decodeStream(ims);
            pokemonImage.setImageBitmap(bitmapSprite);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        //set the colour based off the type
        ArrayList<Type> types = new ArrayList<>();
        for(String sType : selectedPokemon.getAllTypes())
            types.add(Type.valueOf(sType.toUpperCase()));
        int typeColour = Type.getColourFromType(types);
        typeView.setBackgroundColor(typeColour);

        //set the id/name box
        pokemonTitleTextView.setText(selectedPokemon.getId() + " - " + selectedPokemon.getEnglishName());

        //set all base stats
        hpTextView.setText(String.valueOf(selectedPokemon.getBase().getHp()));
        speedTextView.setText(String.valueOf(selectedPokemon.getBase().getSpeed()));
        attackTextView.setText(String.valueOf(selectedPokemon.getBase().getAttack()));
        defenseTextView.setText(String.valueOf(selectedPokemon.getBase().getDefense()));
        spAttackTextView.setText(String.valueOf(selectedPokemon.getBase().getSpecialAttack()));
        spDefenseTextView.setText(String.valueOf(selectedPokemon.getBase().getSpecialDefense()));
    }
}
