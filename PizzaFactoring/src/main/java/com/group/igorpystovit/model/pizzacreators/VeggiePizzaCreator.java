package com.group.igorpystovit.model.pizzacreators;

public class VeggiePizzaCreator implements PizzaCreator {
    public void box(){
        System.out.println("Boxing veggie");
    }

    @Override
    public void cut() {
        System.out.println("Cutting veggie");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing veggie");
    }

    @Override
    public void bake() {
        System.out.println("Baking veggie");
    }
}
