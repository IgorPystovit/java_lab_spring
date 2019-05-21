package com.group.igorpystovit.model.pizzacreators;

public interface PizzaCreator {
    default void create(){
        prepare();
        bake();
        cut();
        box();
    }

    void prepare();
    void bake();
    void cut();
    void box();
}
