package com.epam.igorpystovit.view;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements Menu{
    @Override
    public Map<Integer, String> initializeItems() {
        Map<Integer,String> menuItems = new HashMap<>(){{
            put(1,"binary tree map task");
        }};
        return menuItems;
    }

    @Override
    public Map<Integer, Runnable> initializeActions() {
        Map<Integer,Runnable> menuActions = new HashMap<>(){{
            put(1,new BinaryTreeMenu()::launch);
        }};
        return menuActions;
    }
}
