package com.group.igorpystovit.model.pizzacreators;

public class DiabloPizzaCreator implements PizzaCreator {
    @Override
    public void bake() {
        System.out.println("Baking diablo");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing diablo");
    }

    @Override
    public void cut() {
        System.out.println("Cutting diablo");
    }

    @Override
    public void box() {
        System.out.println("Boxing diablo");
    }

}
