package com.example.gdineen.pokedex.Models;

public class Base {
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public Base(){}

    public Base(int h, int a, int d, int sa, int sd, int s){
        hp = h;
        attack = a;
        defense = d;
        specialAttack = sa;
        specialDefense = sd;
        speed = s;
    }

    //setters
    public void setHp(int hp) { this.hp = hp; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defence) { this.defense = defence; }
    public void setSpecialAttack(int specialAttack) { this.specialAttack = specialAttack; }
    public void setSpecialDefense(int specialDefence) { this.specialDefense = specialDefence; }
    public void setSpeed(int speed) { this.speed = speed; }

    //getters
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpecialAttack() { return specialAttack; }
    public int getSpecialDefense() { return specialDefense; }
    public int getSpeed() { return speed; }

}
