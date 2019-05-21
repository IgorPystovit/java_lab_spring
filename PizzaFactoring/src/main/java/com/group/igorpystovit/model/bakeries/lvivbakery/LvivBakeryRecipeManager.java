package com.group.igorpystovit.model.bakeries.lvivbakery;

import com.group.igorpystovit.model.Ingredient;
import com.group.igorpystovit.model.Pizza;

//size of pizza and its price is known to PizzaCreator
public class LvivBakeryRecipeManager {
    public Pizza pepperoni = new Pizza("Pepperoni",
            new Ingredient("tomato",10),
            new Ingredient("dough",20),
            new Ingredient("cheese",15.2));

    public Pizza diablo = new Pizza("Diablo",
            new Ingredient("cheese",10),
            new Ingredient("olive",24.3),
            new Ingredient("beef",49));
    public Pizza margarita = new Pizza("Margarita",
            new Ingredient("potato",10.4),
            new Ingredient("tomato",21));
    public Pizza clam  = new Pizza("Clam",
            new Ingredient("potato",5.2),
            new Ingredient("olive",25.1),
            new Ingredient("tomato",52.5),
            new Ingredient("chicken",2));

    public Pizza cheese = new Pizza("Cheese",
            new Ingredient("potato",17.2),
            new Ingredient("cheese",40.2),
            new Ingredient("tomato",10.2));
    public Pizza veggie = new Pizza("Veggie",
            new Ingredient("tomato",24.5),
            new Ingredient("cheese",39));
}
