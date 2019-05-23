package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.Reader;

import java.util.Arrays;
import java.util.Scanner;

public class Invoker {
    private Controller controller = new Controller();
    private Scanner scan = new Scanner(System.in);

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
