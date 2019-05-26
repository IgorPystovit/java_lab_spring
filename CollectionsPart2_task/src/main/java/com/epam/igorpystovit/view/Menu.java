package com.epam.igorpystovit.view;

import com.epam.igorpystovit.model.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public interface Menu {
    Logger logger = LogManager.getLogger(Menu.class.getName());

    Map<Integer,String> initializeItems();
    Map<Integer,Runnable> initializeActions();

    default void launch(){
        Map<Integer,String> menuItems = initializeItems();
        Map<Integer,Runnable> menuActions = initializeActions();

        menuItems.put(0,"EXIT");
        menuActions.put(0,() -> System.out.println("Bye"));

        Integer requestID;
        do{
            printMenuItems(menuItems);
            requestID = Reader.readInt();
            try{
                menuActions.get(requestID).run();
            }catch (NullPointerException e){
                logger.error("Bad request id");
            }
        }while (requestID != 0);
    }

    default void printMenuItems(Map<Integer,String> menuItems){
        logger.info("Menu Items(id/description)");
        menuItems.keySet().stream()
                .forEach(a -> logger.info(a+" - "+menuItems.get(a).toLowerCase()));
    }
}
