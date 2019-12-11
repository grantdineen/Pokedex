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

    public static int getColourFromType(List<Type> types){
        int colour = 0;

        switch (types.get(0)){
            case WATER:
                colour = Colours.BLUE;
                break;
            case GRASS:
            case BUG:
                colour = Colours.GREEN;
                break;
            case POISON:
                colour = Colours.PURPLE;
                break;
            case FIRE:
                colour = Colours.ORANGE;
                break;
            case FLYING:
            case GHOST:
            case DRAGON:
                colour = Colours.INDIGO;
                break;
            case NORMAL:
                colour = Colours.BEIGE;
                break;
            case ROCK:
            case GROUND:
                colour = Colours.BROWN;
                break;
            case DARK:
                colour = Colours.BLACK;
                break;
            case FIGHTING:
                colour = Colours.RED;
                break;
            case PSYCHIC:
            case FAIRY:
                colour = Colours.PINK;
                break;
            case ICE:
                colour = Colours.LIGHTBLUE;
                break;
            case STEEL:
                colour = Colours.GRAY;
                break;
            case ELECTRIC:
                colour = Colours.YELLOW;
                break;
        }

        return colour;
    }
}
