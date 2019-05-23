package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.ArrayHandler;
import com.epam.igorpystovit.view.Printable;

public class Controller {
    private static ArrayHandler arrayHandler = new ArrayHandler();

    public Integer[] deleteTwoTimesOccurrence(Integer[] array){
        return arrayHandler.deleteTwoTimesOccurrence(array);
    }

    public Integer[] combineArrays(Integer[] array1,Integer[] array2){
        return arrayHandler.combineTwoArrays(array1,array2);
    }

    public void printResult(Printable printable){
        printable.print();
    }

}
