package com.group.igorpystovit.model.bakeries.lvivbakery;

import com.group.igorpystovit.model.*;
import com.group.igorpystovit.model.pizzacreators.*;

public class LvivBakery extends PizzaFactory{
    private Pizza pizza;
    private LvivBakeryRecipeManager recipeManager = new LvivBakeryRecipeManager();

    private Pizza getPizzaRecipe(PizzaTypes pizzaType){
        Pizza pizzaRecipe;

        switch (pizzaType){
            case CLAM:
                pizzaRecipe = recipeManager.clam;
                break;
            case CHEESE:
                pizzaRecipe = recipeManager.cheese;
                break;
            case DIABLO:
                pizzaRecipe = recipeManager.diablo;
                break;
            case VEGGIE:
                pizzaRecipe = recipeManager.veggie;
                break;
            case MARGARITA:
                pizzaRecipe = recipeManager.margarita;
                break;
            case PEPPERONI:
                pizzaRecipe = recipeManager.pepperoni;
                break;
            default:
                pizzaRecipe = null;
                logger.error("No such pizza type");
        }
        return pizzaRecipe;
    }

    @Override
    protected Pizza getPizza(PizzaTypes pizzaType, PizzaSize pizzaSize) {
        System.out.println("making pizza at Lviv bakery");
        pizza = getPizzaRecipe(pizzaType);
        pizza.setPrice(calculatePrice(pizza,pizzaSize));
        return pizza;
    }

}
