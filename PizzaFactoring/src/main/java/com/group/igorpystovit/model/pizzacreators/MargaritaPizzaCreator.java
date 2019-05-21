package com.group.igorpystovit.model.pizzacreators;

public class MargaritaPizzaCreator implements PizzaCreator {
    @Override
    public void bake() {
        System.out.println("Baking margarita");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing margarita");
    }

    @Override
    public void cut() {
        System.out.println("Cutting margarita");
    }

    @Override
    public void box() {
        System.out.println("Boxing margarita");
    }
}
