package com.epam.igorpystovit.view;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu extends Menu{
    @Override
    public Map<Integer, String> initializeItems() {
        Map<Integer,String> menuItems = new LinkedHashMap<>(){{
            put(1,resourceBundle.getString("Menu.toManipulateStrings"));
            put(2,resourceBundle.getString("Menu.toManipulateText"));
        }};
        return menuItems;
    }

    @Override
    public Map<Integer, Runnable> initializeActions() {
        Map<Integer,Runnable> menuActions = new LinkedHashMap<>(){{
            put(1,StringHandlerMenu::new);
            put(2,TextHandlerMenu::new);
        }};
        return menuActions;
    }
}
