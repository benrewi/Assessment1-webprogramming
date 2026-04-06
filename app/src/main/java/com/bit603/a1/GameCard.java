package com.bit603.a1;

import android.content.Context;

public class GameCard {

    private String card_id;
    private String name;
    private String effect_description;
    private int level;
    private int battle_power;
    private int play_cost;
    private int element;
    private String artist_name;
    private boolean unfinished;

    public GameCard(String card_id, String name, String effect_description, int level, int battle_power, int play_cost, int element, String artist_name, boolean unfinished){
        this.card_id = card_id;
        this.name = name;
        this.effect_description = effect_description;
        this.level = level;
        this.battle_power = battle_power;
        this.play_cost = play_cost;
        this.element = element;
        this.artist_name = artist_name;
        this.unfinished = unfinished;
    }

    public String getElementName(){
        switch (this.element) {
            case 0:
                return "Neutral";
            case 1:
                return "Earth";
            case 2:
                return "Wind";
            case 3:
                return "Fire";
            case 4:
                return "Water";
            default:
                return "Unknown";
        }
    }

    public String getElementColour() {
        switch (this.element) {
            case 0:
                return "#d4d4d4";
            case 1:
                return "#57503c";
            case 2:
                return "#98b08d";
            case 3:
                return "#691f1f";
            case 4:
                return "#4d7b9e";
            default:
                return "#000000";
        }
    }

    public String getCardID(){
        return card_id;
    }

    public String getName(){
        return name;
    }

    public String getEffectDescription(){
        return effect_description;
    }

    public int getLevel(){
        return level;
    }

    public int getBattlePower(){
        return battle_power;
    }

    public int getPlayCost(){
        return play_cost;
    }

    public int getElement(){
        return element;
    }

    public String getArtistName(){
        return artist_name;
    }

    public boolean getUnfinished(){
        return unfinished;
    }

    public void setCardID(String card_id){
        this.card_id = card_id;
    }

    public void setName(String name){
        this.name = name;
    }
public void setEffectDescription(String effect_description){
        this.effect_description = effect_description;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setBattlePower(int battle_power){
        this.battle_power = battle_power;
    }

    public void setPlayCost(int play_cost){
        this.play_cost = play_cost;
    }

    public void setElement(int element){
        this.element = element;
    }

    public void setArtistName(String artist_name){
        this.artist_name = artist_name;
    }

    public void setUnfinished(boolean unfinished){
        this.unfinished = unfinished;
    }

}
