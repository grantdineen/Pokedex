package com.example.gdineen.pokedex.DataManager;

import android.content.Context;
import android.widget.Toast;

import com.example.gdineen.pokedex.Activities.MainActivity;
import com.example.gdineen.pokedex.Models.Base;
import com.example.gdineen.pokedex.Models.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PokemonDataManager {
    private static PokemonDataManager instance = null;
    private Context ctx;

    private List<Pokemon> pokemon;

    public static PokemonDataManager getInstance(Context ctx){
        if(instance == null)
            instance = new PokemonDataManager(ctx);
        return instance;
    }

    private PokemonDataManager(Context ctx){
        this.ctx = ctx;
        pokemon = new ArrayList<>();
        ImportPokemonFromJson();
    }

    private boolean ImportPokemonFromJson(){
        String json = readJsonAsString();

        if(json == null)
            return false;

        try{
            JSONArray jsonArray = new JSONArray(json);

            //foreach json object in the json file
            for (int i = 0; i < jsonArray.length(); i++) {
                // get the id
                JSONObject pokemonJSONObject = jsonArray.getJSONObject(i);
                int id = pokemonJSONObject.getInt("id");

                //get the names
                JSONObject nameJSONObject = pokemonJSONObject.getJSONObject("name");
                List<String> names = new ArrayList<>();
                names.add(nameJSONObject.getString("english"));
                names.add(nameJSONObject.getString("japanese"));
                names.add(nameJSONObject.getString("chinese"));
                names.add(nameJSONObject.getString("french"));

                //get the types
                JSONArray typesJSONArray = pokemonJSONObject.getJSONArray("type");
                List<String> types = new ArrayList<>();
                for(int j = 0; j < typesJSONArray.length(); j++){
                    types.add(typesJSONArray.getString(j));
                }

                //get Base
                Base base = new Base();
                JSONObject baseJSONObject = pokemonJSONObject.getJSONObject("base");
                base.setHp(baseJSONObject.getInt("HP"));
                base.setAttack(baseJSONObject.getInt("Attack"));
                base.setDefense(baseJSONObject.getInt("Defense"));
                base.setSpecialAttack(baseJSONObject.getInt("Sp. Attack"));
                base.setSpecialDefense(baseJSONObject.getInt("Sp. Defense"));
                base.setSpeed(baseJSONObject.getInt("Speed"));

                //construct new pokemon and add to list
                Pokemon p = new Pokemon(id, names, types, base);
                pokemon.add(p);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    private String readJsonAsString(){
        String json = null;
        try {
            InputStream is = ctx.getAssets().open("pokedex.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<Pokemon> getAllPokemon(){
        return pokemon;
    }
}
