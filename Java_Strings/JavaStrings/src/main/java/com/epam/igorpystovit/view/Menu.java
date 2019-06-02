package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;
import com.epam.igorpystovit.model.LanguageFormatter;
import com.epam.igorpystovit.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.ResourceBundle;

public abstract class Menu {
    protected static ResourceBundle resourceBundle;
    protected Controller controller;
    protected Reader reader = new Reader();
    protected Logger logger = LogManager.getLogger(Menu.class.getName());


    public abstract Map<Integer,String> initializeItems();
    public abstract Map<Integer,Runnable> initializeActions();

    public void launch(){
        reader = new Reader(resourceBundle);
        controller = new Controller(resourceBundle);

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



    protected void printMenuItems(Map<Integer,String> menuItems){
        logger.info(resourceBundle.getString("Menu.description"));
        menuItems.keySet().stream()
                .forEach(a -> logger.info(a+" - "+menuItems.get(a).toLowerCase()));
    }
}
