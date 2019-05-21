package com.group.igorpystovit.model;

import com.group.igorpystovit.model.pizzacreators.PizzaCreatorFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PizzaFactory{
    protected Logger logger = LogManager.getLogger(PizzaFactory.class.getName());

    protected abstract Pizza getPizza(PizzaTypes pizzaType, PizzaSize pizzaSize);

    protected double calculatePrice(Pizza pizza,PizzaSize pizzaSize){
        double price = 0.0;
        for (Ingredient ingredient : pizza.getIngredients()){
            price += ingredient.getPrice() * pizzaSize.getCoefficient();
        }
        return price;
    }

    public Pizza makePizza(PizzaTypes pizzaType, PizzaSize pizzaSize){
        Pizza pizza = getPizza(pizzaType,pizzaSize);
        PizzaCreatorFactory.getPizzaCreator(pizzaType).create();
        return pizza;
    }
}
