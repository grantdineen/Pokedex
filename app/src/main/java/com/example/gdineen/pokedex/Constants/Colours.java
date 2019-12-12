package com.example.gdineen.pokedex.Constants;

import android.graphics.Color;

public class Colours {
    public static final int RED = Color.rgb(227, 49, 36);
    public static final int GREEN = Color.rgb(11, 176, 5);
    public static final int BLUE = Color.rgb(33, 143, 222);
    public static final int YELLOW = Color.rgb(250, 236, 37);
    public static final int PURPLE = Color.rgb(166, 47, 250);
    public static final int ORANGE = Color.rgb(255, 140, 0);
    public static final int BROWN = Color.rgb(107, 59, 0);
    public static final int PINK = Color.rgb(255, 143, 227);
    public static final int LIGHTBLUE = Color.rgb(140, 232, 255);
    public static final int BLACK = Color.rgb(64, 64, 64);
    public static final int INDIGO = Color.rgb(168, 119, 181);
    public static final int BEIGE = Color.rgb(230, 216, 197);
    public static final int GRAY = Color.rgb(171, 171, 171);

    public static int mixTwoColors( int color1, int color2, float amount ) {
        final byte ALPHA_CHANNEL = 24;
        final byte RED_CHANNEL   = 16;
        final byte GREEN_CHANNEL =  8;
        final byte BLUE_CHANNEL  =  0;

        final float inverseAmount = 1.0f - amount;

        int a = ((int)(((float)(color1 >> ALPHA_CHANNEL & 0xff )*amount) +
                ((float)(color2 >> ALPHA_CHANNEL & 0xff )*inverseAmount))) & 0xff;
        int r = ((int)(((float)(color1 >> RED_CHANNEL & 0xff )*amount) +
                ((float)(color2 >> RED_CHANNEL & 0xff )*inverseAmount))) & 0xff;
        int g = ((int)(((float)(color1 >> GREEN_CHANNEL & 0xff )*amount) +
                ((float)(color2 >> GREEN_CHANNEL & 0xff )*inverseAmount))) & 0xff;
        int b = ((int)(((float)(color1 & 0xff )*amount) +
                ((float)(color2 & 0xff )*inverseAmount))) & 0xff;

        return a << ALPHA_CHANNEL | r << RED_CHANNEL | g << GREEN_CHANNEL | b << BLUE_CHANNEL;
    }
}
