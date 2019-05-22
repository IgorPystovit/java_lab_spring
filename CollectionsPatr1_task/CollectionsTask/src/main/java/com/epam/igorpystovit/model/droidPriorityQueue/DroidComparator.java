package com.epam.igorpystovit.model.droidPriorityQueue;

import com.epam.igorpystovit.model.shipwithdroids.Droid;

import java.util.Comparator;

public class DroidComparator<T extends Droid> implements Comparator<T> {
    public int compare(T d1,T d2){
        return Double.compare(d1.getStrength(),d2.getStrength());
    }
}
