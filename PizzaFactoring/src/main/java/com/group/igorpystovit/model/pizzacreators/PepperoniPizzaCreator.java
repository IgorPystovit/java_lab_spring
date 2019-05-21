package com.group.igorpystovit.model.pizzacreators;

public class PepperoniPizzaCreator implements PizzaCreator {
    public void box(){
        System.out.println("Boxing pepperoni");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pepperoni");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni");
    }

    @Override
    public void bake() {
        System.out.println("Baking pepperoni");
    }
}
