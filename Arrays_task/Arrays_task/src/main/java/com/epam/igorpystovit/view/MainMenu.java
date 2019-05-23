package com.epam.igorpystovit.view;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu implements Menu{
    private Map<String,String> menuItems;
    private Map<String,Runnable> menuActions;

    @Override
    public Map<String, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
           put("ARRAY HANDLER",new ArrayHandlerMenu()::launch);
           put("STRING CONTAINER",new StringContainerMenu()::launch);
        }};
        return menuActions;
    }

    @Override
    public Map<String, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put("ARRAY HANDLER","to invoke array handler menu");
            put("STRING CONTAINER","to invoke string handler menu");
        }};
        return menuItems;
    }
}
