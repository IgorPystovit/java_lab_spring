package com.epam.igorpystovit.view;

import com.epam.igorpystovit.model.LanguageFormatter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainMenu extends Menu{

    public MainMenu(){
        resourceBundle = langDetector();
    }

    private ResourceBundle langDetector(){
        ResourceBundle resourceBundle;
        System.out.println("Select a language:");
        for (LanguageFormatter langFormatter : LanguageFormatter.values()){
            System.out.println("- "+langFormatter.toString().toLowerCase()+";");
        }
        String lang = reader.readString().toUpperCase();
        switch (lang){
            case "ENGLISH":
                resourceBundle = LanguageFormatter.ENGLISH.getResourceBundle();
                break;
            case "РУССКИЙ":
                resourceBundle = LanguageFormatter.РУССКИЙ.getResourceBundle();
                break;
            case "DEUTCH":
                resourceBundle = LanguageFormatter.DEUTCH.getResourceBundle();
                break;
            default:
                logger.info("No such language. Set english by default");
                resourceBundle = LanguageFormatter.ENGLISH.getResourceBundle();
        }
        return resourceBundle;
    }

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
            put(1,new StringHandlerMenu()::launch);
            put(2,new TextHandlerMenu()::launch);
        }};
        return menuActions;
    }
}
