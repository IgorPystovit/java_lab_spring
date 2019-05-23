package com.epam.igorpystovit.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.Scanner;

public interface Menu {
    Logger logger = LogManager.getLogger(Menu.class.getName());
    Scanner scan = new Scanner(System.in);

    default void launch(){

         Map<String,String> menuItems = initializeItems();
         Map<String,Runnable> menuActions = initializeActions();
         menuActions.put("EXIT",() -> System.out.println("Bye"));

         if (menuItems == null){
             logger.fatal("Initialization error");
             return;
         }

         String request;
         do{
             printMenuItems(menuItems);
             System.out.println("\nType your request:");
             request = scan.nextLine().toUpperCase();
             try{
                 menuActions.get(request).run();
                 System.out.println();
             }catch (NullPointerException e){
                logger.error("Bad request");
             }
         }while (!request.equals("EXIT"));

     }

     Map<String,Runnable> initializeActions();
     Map<String,String> initializeItems();

     default void printMenuItems(Map<String,String> map){
         System.out.println("Menu items: ");
         map.keySet().stream()
                .forEach(a -> System.out.println("- "+a.toLowerCase()+"("+map.get(a)+");"));
         System.out.println("Type \"Exit\" to exit the program");
     }
}
