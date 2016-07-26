package com.microsoft.hack.whatthediet.models;

import java.util.List;

/**
 * Created by prmeno on 7/26/2016.
 */
public class FoodItem {

    private String name;
    private Nutrition nutrition;
    private List<Ingredient> ingredients;

    public FoodItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
