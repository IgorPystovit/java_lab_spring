package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.ArrayHandler;
import com.epam.igorpystovit.view.Reader;
import com.epam.igorpystovit.model.StringContainer;
import com.epam.igorpystovit.view.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Controller {
    private static ArrayHandler arrayHandler = new ArrayHandler();
    private static Logger logger = LogManager.getLogger(Controller.class.getName());
    private StringContainer stringContainer = new StringContainer();

    public Integer[] deleteTwoTimesOccurrence(){
        System.out.println("Input array");
        return arrayHandler.deleteTwoTimesOccurrence(Reader.readIntArray());
    }

    public Integer[] combineArrays(){
        System.out.println("Input first array");
        Integer[] array1 = Reader.readIntArray();
        System.out.println("Input second array");
        Integer[] array2 = Reader.readIntArray();
        return arrayHandler.combineTwoArrays(array1,array2);
    }

    public void printArray(Object[] array){
        System.out.println("Resulted array");
        Arrays.stream(array)
                .forEach(a -> System.out.print(a+" "));
    }

    public int getStringContainerSize(){
        System.out.println("Container current size = "+stringContainer.size());
        return stringContainer.size();
    }

    public String getStringFromContainer(){
        logger.info("Input string index");
        int index = Reader.readIntValue();
        String neededString = null;
        try{
            neededString = stringContainer.get(index);
            logger.info("String at index "+index+": "+neededString);
        } catch (IndexOutOfBoundsException e){
            logger.warn("Wrong index");
        } catch (Exception e){
            logger.warn("Something went wrong");
        }
        return neededString;
    }

    public boolean putStringIntoContainer(){
        System.out.println("Input string to put");
        return stringContainer.put(Reader.readString());
    }

    public void printStringContainerContent(){
        if (stringContainer.isEmpty()){
            System.out.println("No content");
        }else{
            System.out.println("Container content");
            for (int i = 0; i < stringContainer.size(); i++){
                String containerElement = stringContainer.get(i);
                int elementIndex = stringContainer.indexOf(containerElement);
                logger.info(elementIndex+": "+containerElement);
            }
        }
    }

    public boolean checkStringContainerState(){
        boolean state = stringContainer.isEmpty();
        if (state){
            System.out.println("Container's empty");
        }else{
            System.out.println("Container isn't empty");
        }
        return state;
    }

    public void printResult(Printable printable){
        printable.print();
    }

}
