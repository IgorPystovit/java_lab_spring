package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Invoker;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayHandlerMenu implements Menu{
    private Map<String,String> menuItems;
    private Map<String,Runnable> menuActions;
    private Invoker invoker = new Invoker();

    @Override
    public Map<String, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
            put("DELETE TWO TIMES OCCURRENCE",invoker::invokeDeleteTwoTimesOccurrence);
            put("COMBINE ARRAYS",invoker::invokeCombineTwoArrays);
        }};
        return menuActions;
    }

    @Override
    public Map<String, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put("DELETE TWO TIMES OCCURRENCE","");
            put("COMBINE ARRAYS","");
        }};
        return menuItems;
    }


}
