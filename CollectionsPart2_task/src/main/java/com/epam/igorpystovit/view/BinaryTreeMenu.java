package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMenu implements Menu{
    private Controller controller = new Controller();

    @Override
    public Map<Integer, Runnable> initializeActions() {
        Map<Integer,Runnable> menuActions = new HashMap<>(){{
            put(1,controller::getBinaryTreeSize);
            put(2,controller::putValueIntoTree);
            put(3,controller::getValueFromTree);
            put(4,controller::removeValueFromTree);
            put(5,controller::treeContainsKey);
            put(6,controller::print);
        }};
        return menuActions;
    }

    @Override
    public Map<Integer, String> initializeItems() {
        Map<Integer,String> menuItems = new HashMap<>(){{
            put(1,"get tree size");
            put(2,"put value into tree");
            put(3,"get value from tree");
            put(4,"remove value from tree");
            put(5,"check if tree contains key");
            put(6,"print tree");
        }};
        return menuItems;
    }
}
