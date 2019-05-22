package com.epam.igorpystovit.view.menu;

import com.epam.igorpystovit.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class GeneralMenu implements Menu{
    private Controller controller = new Controller();
    private Map<String,Runnable> general = new HashMap<>();

    private void initializeGeneral(){
        general.put("DROID MANAGER",new DroidMenu()::show);
        general.put("PRIORITY DROID MANAGER",new PriorityDroidMenu()::show);
        general.put("EXIT",() -> System.out.println("Bye!"));
    }

    private void printGeneralMenu(){
        general.keySet().stream().forEach(a ->System.out.println("-"+a.toLowerCase()));
    }

    @Override
    public void show() {
        initializeGeneral();
        do{
            System.out.println("Actions:");
            controller.printResult(this::printGeneralMenu);
            String request = controller.scanRequest();
            try{
                general.get(request).run();
            }catch (NullPointerException e){
                System.out.println("No such request");
            }
            if (request.equals("EXIT")){
                return;
            }
        }while (true);
    }


    public static void main(String[] args) {
        new GeneralMenu().show();
    }
}
