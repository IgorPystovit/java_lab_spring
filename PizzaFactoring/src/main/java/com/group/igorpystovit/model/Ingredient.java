package com.group.igorpystovit.model;

public class Ingredient {
    private double price;
    private String name;

    public Ingredient(){}
    public Ingredient(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name+": "+price+"$ ");
        return sb.toString();
    }
}
