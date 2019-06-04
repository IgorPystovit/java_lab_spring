package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayHandlerMenu implements Menu{
    private Map<Integer,String> menuItems;
    private Map<Integer,Runnable> menuActions;
    private Controller controller = new Controller();

    @Override
    public Map<Integer, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
            put(1,() -> controller.printArray(controller.deleteTwoTimesOccurrence()));
            put(2,() -> controller.printArray(controller.combineArrays()));
        }};
        return menuActions;
    }

    @Override
    public Map<Integer, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put(1,"delete numbers that occurs more that 2 times");
            put(2,"combine two arrays");
        }};
        return menuItems;
    }

    private void printArray(Integer[] array){
        Arrays.stream(array).forEach(a -> System.out.print(a+" "));
    }


}
