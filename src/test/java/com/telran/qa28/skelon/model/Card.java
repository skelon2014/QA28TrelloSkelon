package com.telran.qa28.skelon.model;

public class Card {
    String color;
    String name;

    public String getColor() {
        return color;
    }

    public Card withColor(String color) {
        this.color = color;
        return this;
    }

    public String getName() {
        return name;
    }

    public Card withName(String name) {
        this.name = name;
        return this;
    }

}
