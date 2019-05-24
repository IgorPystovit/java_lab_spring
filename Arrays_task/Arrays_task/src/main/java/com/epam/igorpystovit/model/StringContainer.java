package com.epam.igorpystovit.model;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

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
            throw new IndexOutOfBoundsException();
        }
        return stringContainer[index];
    }

    public int indexOf(Object o){
        if (!(o instanceof String)){
            throw new NoSuchElementException();
        }
        int elementIndex = -1;
        if (!isEmpty()){
            for (int i = 0; i < capacity; i++){
                if (get(i).equals(o)){
                    elementIndex = i;
                    break;
                }
            }
        }
        return elementIndex;
    }

    public boolean put(String string){
        boolean modified = false;
        if (indexOf(string) < 0){
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
        }
        return modified;
    }

}
