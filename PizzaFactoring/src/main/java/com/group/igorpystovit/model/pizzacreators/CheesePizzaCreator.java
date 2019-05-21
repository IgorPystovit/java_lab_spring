package com.group.igorpystovit.model.pizzacreators;

public class CheesePizzaCreator implements PizzaCreator {

    public void box(){
        System.out.println("Boxing clam");
    }

    @Override
    public void cut() {
        System.out.println("Cutting clam");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing clam");
    }

    @Override
    public void bake() {
        System.out.println("Baking clam");
    }
}
