package com.group.igorpystovit.view;

import com.group.igorpystovit.controller.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu implements Menu{
    private Map<String,Runnable> mainMenu = new LinkedHashMap<>();
    private Controller controller = new Controller();

    private Map<String,Runnable> menuInitializer(){
        mainMenu.put("EXIT",()->System.exit(0));
        mainMenu.put("EMERGENCY EXIT",() -> System.exit(1));
        return mainMenu;
    }

    @Override
    public void show() {
        menuInitializer();
        controller.printResult(this::printMainMenu);
    }

    private void printMainMenu(){
        System.out.println("Actions:");
        for(String action : mainMenu.keySet()){
            System.out.println(action.toLowerCase());
        }
    }

    public static void main(String[] args) {
        new MainMenu().show();
    }
}
