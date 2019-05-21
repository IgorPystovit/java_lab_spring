package com.group.igorpystovit.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pizza{
    private String name;
    private Set<Ingredient> ingredients;
    private double price;

    public Pizza(){}
    public Pizza(String name, Ingredient... ingredients){
        this.name = name;
        this.ingredients = new HashSet<>(Arrays.asList(ingredients));
    }

    public String getName() {
        return name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name+"{\n");
        sb.append("Ingredients:\n ");
        for (Ingredient ingredient : ingredients){
            sb.append(ingredient+";\n");
        }
        sb.append("Price: "+price+";\n");
        sb.append("}\n");
        return sb.toString();
    }
}
