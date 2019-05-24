package com.epam.igorpystovit.view;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu implements Menu{
    private Map<Integer,String> menuItems;
    private Map<Integer,Runnable> menuActions;

    @Override
    public Map<Integer, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
           put(1,new ArrayHandlerMenu()::launch);
           put(2,new StringContainerMenu()::launch);
        }};
        return menuActions;
    }

    @Override
    public Map<Integer, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put(1,"to invoke array handler menu");
            put(2,"to invoke string handler menu");
        }};
        return menuItems;
    }
}
