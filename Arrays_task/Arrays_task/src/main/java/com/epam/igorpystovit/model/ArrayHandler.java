package com.epam.igorpystovit.model;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayHandler {
    public Integer[] deleteTwoTimesOccurrence(Integer[] array){
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int number : array){
            int occurrenceCount = 0;
            for (int tempNum : array){
                if (tempNum == number){
                    occurrenceCount++;
                }
                if (occurrenceCount > 2){
                    deleteSet.add(number);
                    break;
                }
            }
        }

        for (Integer tempNum : deleteSet){
            array = deleteOccurrences(array,tempNum);
        }

        return array;
    }

    public Integer[] combineTwoArrays(Integer[] array1,Integer[] array2){
        List<Integer> doubledArray = new ArrayList<>();
        doubledArray.addAll(Arrays.asList(array1));
        doubledArray.addAll(Arrays.asList(array2));
        return doubledArray.toArray(new Integer[0]);
    }

    private Integer[] deleteOccurrences(Integer[] array,Integer deleteNum){
        return Arrays.stream(array)
                .filter(a -> a != deleteNum)
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }

}
