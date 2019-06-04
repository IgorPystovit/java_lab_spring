package com.epam.igorpystovit.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.Scanner;

public interface Menu {
    Logger logger = LogManager.getLogger(Menu.class.getName());

    default void launch(){

         Map<Integer,String> menuItems = initializeItems();
         Map<Integer,Runnable> menuActions = initializeActions();
         menuActions.put(0,() -> System.out.println("Bye"));
         menuItems.put(0,"TO EXIT");

         Integer requestID;
         do{
             printMenuItems(menuItems);
             System.out.println("\nInput requestID:");
             requestID = Reader.readIntValue();
             try{
                 menuActions.get(requestID).run();
                 System.out.println();
             }catch (NullPointerException e){
                logger.error("Bad requestID");
             }
         }while (requestID != 0);

     }

     Map<Integer,Runnable> initializeActions();
     Map<Integer,String> initializeItems();

     default void printMenuItems(Map<Integer,String> map){
         System.out.println("Menu items (id,description): ");

         map.keySet().stream()
                .forEach(a -> System.out.println(a+"-"+"("+map.get(a).toLowerCase()+");"));
     }
}
