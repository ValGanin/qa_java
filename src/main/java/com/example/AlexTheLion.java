package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlexTheLion extends Lion {
    public AlexTheLion(Feline feline) throws Exception {
        super("Самец", feline);
        this.newYorkZoo = "newYorkZoo";
    }
    List<String> friends = new ArrayList<>(Arrays.asList("Marty", "Glory", "Melman"));
    String newYorkZoo;
    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getHomeLand() {
        return newYorkZoo;
    }
}