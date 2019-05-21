package com.group.igorpystovit.model.pizzacreators;

import com.group.igorpystovit.model.PizzaTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PizzaCreatorFactory {
    private static Logger logger = LogManager.getLogger(PizzaCreatorFactory.class.getName());

    public static PizzaCreator getPizzaCreator(PizzaTypes pizzaType){
        PizzaCreator pizzaCreator = null;

        switch (pizzaType){
            case CLAM:
                pizzaCreator = new ClamPizzaCreator();
                break;
            case CHEESE:
                pizzaCreator = new CheesePizzaCreator();
            case DIABLO:
                pizzaCreator = new DiabloPizzaCreator();
                break;
            case VEGGIE:
                pizzaCreator = new VeggiePizzaCreator();
                break;
            case MARGARITA:
                pizzaCreator = new MargaritaPizzaCreator();
                break;
            case PEPPERONI:
                pizzaCreator = new PepperoniPizzaCreator();
                break;
            default:
                pizzaCreator = null;
                logger.error("No such pizza type");
        }

        return pizzaCreator;
    }
}
