package com.epam.igorpystovit.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringHandlerMenu extends Menu {

    @Override
    public Map<Integer, String> initializeItems() {
        Map<Integer,String> menuItems = new LinkedHashMap<>(){{
           put(1,resourceBundle.getString("Menu.replaceVowels"));
           put(2,resourceBundle.getString("Menu.splitSentence"));
        }};
        return menuItems;
    }

    @Override
    public Map<Integer, Runnable> initializeActions() {
        Map<Integer,Runnable> menuActions = new LinkedHashMap<>(){{
            put(1,() -> {
                logger.info(resourceBundle.getString("Info.inputString"));
                controller.replaceVowels();
            });
            put(2,() -> {
                logger.info(resourceBundle.getString("Info.inputString"));
                String sentence = reader.readString();
                logger.info(resourceBundle.getString("Info.inputRegular"));
                String regularExpression = reader.readString();
                controller.splitString(sentence,regularExpression);
            });
        }};
        return menuActions;
    }
}
