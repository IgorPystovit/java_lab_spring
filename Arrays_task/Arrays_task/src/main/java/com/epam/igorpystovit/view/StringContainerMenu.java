package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;

import java.util.LinkedHashMap;
import java.util.Map;


public class StringContainerMenu implements Menu{
    private Controller controller = new Controller();
    private Map<Integer,String> menuItems;
    private Map<Integer,Runnable> menuActions;

    @Override
    public Map<Integer, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put(1,"CHECK STATE");
            put(2,"GET SIZE");
            put(3,"PUT STRING");
            put(4,"GET STRING");
            put(5,"PRINT STRING CONTAINER CONTENT");
        }};
        return menuItems;
    }

    @Override
    public Map<Integer, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
            put(1,controller::checkStringContainerState);
            put(2,controller::getStringContainerSize);
            put(3,controller::putStringIntoContainer);
            put(4,controller::getStringFromContainer);
            put(5,controller::printStringContainerContent);
        }};
        return menuActions;
    }
}
