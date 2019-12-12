package com.example.gdineen.pokedex.Models;

import android.graphics.Color;

import com.example.gdineen.pokedex.Constants.Colours;

import java.util.List;

public enum Type {
    WATER,
    GRASS,
    POISON,
    FIRE,
    FLYING,
    NORMAL,
    BUG,
    ROCK,
    DARK,
    FIGHTING,
    PSYCHIC,
    GHOST,
    ICE,
    GROUND,
    STEEL,
    DRAGON,
    FAIRY,
    ELECTRIC;

    public static int getPokemonTypeColour(List<Type> types){
        int pokemonColour = getColourFromType(types.get(0));

        for(int i = 1; i < types.size(); i++){
            int nextColour = getColourFromType(types.get(i));
            pokemonColour = Colours.mixTwoColors(pokemonColour, nextColour, 0.5f);
        }

        return pokemonColour;
    }

    private static int getColourFromType(Type type){
        switch (type){
            case WATER:
                return Colours.BLUE;
            case GRASS:
            case BUG:
                return Colours.GREEN;
            case POISON:
                return Colours.PURPLE;
            case FIRE:
                return Colours.ORANGE;
            case FLYING:
            case GHOST:
            case DRAGON:
                return Colours.INDIGO;
            case NORMAL:
                return Colours.BEIGE;
            case ROCK:
            case GROUND:
                return Colours.BROWN;
            case DARK:
                return Colours.BLACK;
            case FIGHTING:
                return Colours.RED;
            case PSYCHIC:
            case FAIRY:
                return Colours.PINK;
            case ICE:
                return Colours.LIGHTBLUE;
            case STEEL:
                return Colours.GRAY;
            case ELECTRIC:
                return Colours.YELLOW;
            default:
                return Colours.BEIGE;
        }
    }
}
