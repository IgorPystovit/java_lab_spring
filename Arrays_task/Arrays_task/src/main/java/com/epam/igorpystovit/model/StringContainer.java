package com.epam.igorpystovit.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StringContainer {
    private int INITIAL_CAPACITY = 16;
    private int capacity;
    private String[] stringContainer = new String[INITIAL_CAPACITY];

    private int checkCapacity(){
        return INITIAL_CAPACITY - capacity;
    }

    private void increaseInitialCapacity(){
        INITIAL_CAPACITY += INITIAL_CAPACITY * 0.5;
        stringContainer = Arrays.copyOf(stringContainer,INITIAL_CAPACITY);
    }

    public int size(){
        return capacity;
    }

    public boolean isEmpty(){
        return capacity == 0;
    }

    public String get(int index){
        if (index > capacity){
            throw new NoSuchElementException();
        }
        return stringContainer[index];
    }

    public boolean put(String string){
        boolean modified = false;
        for (int i = 0; i < INITIAL_CAPACITY; i++){
            if (stringContainer[i] == null){
                stringContainer[i] = string;
                modified = true;
                capacity++;
                break;
            }
        }
        if (checkCapacity() <= 1){
            increaseInitialCapacity();
        }
        return modified;
    }

}
