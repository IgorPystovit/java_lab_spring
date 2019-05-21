package com.group.igorpystovit;

import com.group.igorpystovit.model.Pizza;
import com.group.igorpystovit.model.PizzaFactory;
import com.group.igorpystovit.model.PizzaSize;
import com.group.igorpystovit.model.PizzaTypes;
import com.group.igorpystovit.model.bakeries.lvivbakery.LvivBakery;

public class Test {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new LvivBakery();
        Pizza pizza = pizzaFactory.makePizza(PizzaTypes.CLAM, PizzaSize.MEDIUM);
        System.out.println(pizza);
    }
}
