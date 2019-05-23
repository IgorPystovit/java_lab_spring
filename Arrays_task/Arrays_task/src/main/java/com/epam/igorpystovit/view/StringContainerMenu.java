package com.epam.igorpystovit.view;

import com.epam.igorpystovit.model.Reader;
import com.epam.igorpystovit.model.StringContainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class StringContainerMenu implements Menu{
    private StringContainer stringContainer = new StringContainer();
    private Map<String,String> menuItems;
    private Map<String,Runnable> menuActions;

    @Override
    public Map<String, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put("CHECK STATE","");
            put("SIZE","");
            put("PUT STRING","");
            put("GET STRING","");
        }};
        return menuItems;
    }

    @Override
    public Map<String, Runnable> initializeActions() {
        StringContainerMenu stringContainerMenu = new StringContainerMenu();
        menuActions = new LinkedHashMap<>(){{
            put("CHECK STATE",stringContainerMenu::checkIfEmpty);
            put("SIZE",stringContainerMenu::getSize);
            put("PUT STRING",stringContainerMenu::putString);
            put("GET STRING",stringContainerMenu::getString);
        }};
        return menuActions;
    }

    public boolean checkIfEmpty(){
        boolean state = stringContainer.isEmpty();
        if (state){
            System.out.println("Container's empty");
        }else{
            System.out.println("Container isn't empty");
        }
        return state;
    }

    public int getSize(){
        int size = stringContainer.size();
        System.out.println("Size = "+size);
        return size;
    }
    public String getString(){
        System.out.println("Input string index");
        int index = Reader.readIntValue();
        String neededString = stringContainer.get(index);
        System.out.println("String at index "+index+": "+neededString);
        return neededString;
    }

    public boolean putString(){
        System.out.println("Input string to put");
        String userString = scan.nextLine();
        return stringContainer.put(userString);
    }
}
