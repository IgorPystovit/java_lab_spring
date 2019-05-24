package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayHandlerMenu implements Menu{
    private Map<Integer,String> menuItems;
    private Map<Integer,Runnable> menuActions;
    private Controller controller = new Controller();

    @Override
    public Map<Integer, Runnable> initializeActions() {
        menuActions = new LinkedHashMap<>(){{
            put(1,() -> controller.printArray(controller.deleteTwoTimesOccurrence()));
            put(2,() -> controller.printArray(controller.combineArrays()));
        }};
        return menuActions;
    }

    @Override
    public Map<Integer, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put(1,"delete numbers that occurs more that 2 times");
            put(2,"combine two arrays");
        }};
        return menuItems;
    }
//
//    public Integer[] invokeDeleteTwoTimesOccurrence(){
//        System.out.println("Input array: ");
//        Integer[] userArray = Reader.readIntArray();
//        userArray = controller.deleteTwoTimesOccurrence(userArray);
//        printArray(userArray);
//        return userArray;
//    }
//
//    public Integer[] invokeCombineTwoArrays(){
//        System.out.println("Input first array: ");
//        Integer[] firstArray = Reader.readIntArray();
//        System.out.println("Input second array: ");
//        Integer[] secondArray = Reader.readIntArray();
//        Integer[] finalArray = controller.combineArrays(firstArray,secondArray);
//        printArray(finalArray);
//        return finalArray;
//    }


    private void printArray(Integer[] array){
        Arrays.stream(array).forEach(a -> System.out.print(a+" "));
    }


}
