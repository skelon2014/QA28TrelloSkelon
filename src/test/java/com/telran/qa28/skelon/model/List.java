package com.telran.qa28.skelon.model;

public class List {
    String name;

    public String getName() {
        return name;
    }

    public List withName(String name) {
        this.name = name;
        return this;
    }
}
