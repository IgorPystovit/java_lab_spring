package com.epam.igorpystovit.view;

import com.epam.igorpystovit.model.LanguageFormatter;
import com.epam.igorpystovit.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.ResourceBundle;

public abstract class Menu {
    protected ResourceBundle resourceBundle;
    private static Reader reader = new Reader();
    private Logger logger = LogManager.getLogger(Menu.class.getName());


    public abstract Map<Integer,String> initializeItems();
    public abstract Map<Integer,Runnable> initializeActions();

    public void launch(){
        resourceBundle = langDetector();
        reader = new Reader(resourceBundle);
        Map<Integer,String> menuItems = initializeItems();
        Map<Integer,Runnable> menuActions = initializeActions();

        menuItems.put(0,resourceBundle.getString("Menu.exit"));
        menuActions.put(0,() -> System.out.println(resourceBundle.getString("Menu.info.bye")));

        Integer requestID;
        do{
            printMenuItems(menuItems);
            requestID = reader.readInt();
            try{
                menuActions.get(requestID).run();
            }catch (NullPointerException e){
                logger.error(resourceBundle.getString("Exception.badRequest"));
            }
        }while (requestID != 0);
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

    protected void printMenuItems(Map<Integer,String> menuItems){
        logger.info(resourceBundle.getString("Menu.description"));
        menuItems.keySet().stream()
                .forEach(a -> logger.info(a+" - "+menuItems.get(a).toLowerCase()));
    }
}
