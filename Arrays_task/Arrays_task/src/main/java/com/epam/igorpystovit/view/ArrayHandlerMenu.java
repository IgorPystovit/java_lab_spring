package com.epam.igorpystovit.view;

import com.epam.igorpystovit.controller.Controller;
import com.epam.igorpystovit.model.Reader;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayHandlerMenu implements Menu{
    private Map<String,String> menuItems;
    private Map<String,Runnable> menuActions;
    private Controller controller = new Controller();

    @Override
    public Map<String, Runnable> initializeActions() {
        ArrayHandlerMenu arrayHandlerMenu = new ArrayHandlerMenu();
        menuActions = new LinkedHashMap<>(){{
            put("DELETE TWO TIMES OCCURRENCE",arrayHandlerMenu::invokeDeleteTwoTimesOccurrence);
            put("COMBINE ARRAYS",arrayHandlerMenu::invokeCombineTwoArrays);
        }};
        return menuActions;
    }

    @Override
    public Map<String, String> initializeItems() {
        menuItems = new LinkedHashMap<>(){{
            put("DELETE TWO TIMES OCCURRENCE","");
            put("COMBINE ARRAYS","");
        }};
        return menuItems;
    }

    public Integer[] invokeDeleteTwoTimesOccurrence(){
        System.out.println("Input array: ");
        Integer[] userArray = Reader.readIntArray();
        userArray = controller.deleteTwoTimesOccurrence(userArray);
        printArray(userArray);
        return userArray;
    }

    public Integer[] invokeCombineTwoArrays(){
        System.out.println("Input first array: ");
        Integer[] firstArray = Reader.readIntArray();
        System.out.println("Input second array: ");
        Integer[] secondArray = Reader.readIntArray();
        Integer[] finalArray = controller.combineArrays(firstArray,secondArray);
        printArray(finalArray);
        return finalArray;
    }


    private void printArray(Integer[] array){
        Arrays.stream(array).forEach(a -> System.out.print(a+" "));
    }


}
