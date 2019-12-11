package com.example.gdineen.pokedex.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.gdineen.pokedex.Models.Base;

public class Pokemon implements Serializable {
    private int id;
    private HashMap<String, String> name;
    private ArrayList<String> type;
    private Base base;

    //constructor
    public Pokemon(int id, List<String> names, List<String> types, Base base)
    {
        this.id = id;

        assert names.size() == 4 : "Names must be provided in all supported languages!";
        this.name = new HashMap<>();
        this.name.put("English", names.get(0));
        this.name.put("Japanese", names.get(1));
        this.name.put("Chinese", names.get(2));
        this.name.put("French", names.get(3));

        type = new ArrayList<>();
        for(String s : types)
            this.type.add(s);

        this.base = base;
    }

    //getters
    public int getId() { return id; }
    public String getEnglishName(){
        return name.get("English");
    }
    public List<String> getAllTypes() { return type; }
    public String getType() { return type.get(0); }

    //sprite image files are the (id)MS.png ex. 001MS.png
    public String getSpriteImagePath(){
        return String.format("sprites/%03dMS.png", id);
    }
    //image files are the (id).png ex. 001.png
    public String getImagePath(){
        return String.format("images/%03d.png", id);
    }
}
