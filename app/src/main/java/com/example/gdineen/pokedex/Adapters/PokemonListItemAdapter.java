package com.example.gdineen.pokedex.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gdineen.pokedex.Models.Pokemon;
import com.example.gdineen.pokedex.R;

import java.io.InputStream;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonListItemAdapter extends RecyclerView.Adapter<PokemonListItemAdapter.PokemonViewHolder>{
    private OnItemClickListener listener;
    private List<Pokemon> pokemon;

    public PokemonListItemAdapter(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void changeData(List<Pokemon> pokemon){
        this.pokemon = pokemon;
        this.notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView name;

        public PokemonViewHolder(View viewItem, final OnItemClickListener listener) {
            super(viewItem);

            icon = viewItem.findViewById(R.id.recyclerviewicon);
            name = viewItem.findViewById(R.id.recyclerviewname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pokemon, parent, false);
        PokemonViewHolder evh = new PokemonViewHolder(v, listener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position){
        Pokemon currentPokemon = pokemon.get(position);

        Context ctx = holder.icon.getContext();
        try{
            InputStream ims = ctx.getAssets().open(currentPokemon.getSpriteImagePath());
            Bitmap bitmapSprite = BitmapFactory.decodeStream(ims);
            holder.icon.setImageBitmap(bitmapSprite);
            holder.name.setText(currentPokemon.getEnglishName());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }
}

