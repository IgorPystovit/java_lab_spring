package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;

import java.util.LinkedHashMap;
import java.util.Map;


public class StringContainerMenu implements Menu{
    private Controller controller = new Controller();
    private Map<Integer,String> menuItems;
    private Map<Integer,Runnable> menuActions;

    @Override
    public Map<Integer, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put(1,"CHECK STATE");
            put(2,"GET SIZE");
            put(3,"PUT STRING");
            put(4,"GET STRING");
            put(5,"PRINT STRING CONTAINER CONTENT");
        }};
        return menuItems;
    }

    @Override
    public Map<Integer, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
            put(1,controller::checkStringContainerState);
            put(2,controller::getStringContainerSize);
            put(3,controller::putStringIntoContainer);
            put(4,controller::getStringFromContainer);
            put(5,controller::printStringContainerContent);
        }};
        return menuActions;
    }

//    public boolean checkStringContainerState(){
//        boolean state = stringContainer.isEmpty();
//        if (state){
//            System.out.println("Container's empty");
//        }else{
//            System.out.println("Container isn't empty");
//        }
//        return state;
//    }


//    public String getString(){
//        System.out.println("Input string index");
//        int index = Reader.readIntValue();
//        String neededString = stringContainer.get(index);
//        System.out.println("String at index "+index+": "+neededString);
//        return neededString;
//    }

//    public boolean putString(){
//        System.out.println("Input string to put");
//        String userString = scan.nextLine();
//        return stringContainer.put(userString);
//    }
}
