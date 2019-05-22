package com.epam.igorpystovit.model.droidPriorityQueue;

import com.epam.igorpystovit.model.droidPriorityQueue.DroidComparator;
import com.epam.igorpystovit.model.shipwithdroids.Droid;

import java.util.*;

public class DroidPriorityQueue<E extends Droid>{
    private LinkedList<E> queue = new LinkedList<>();
    private Comparator<E> comparator = new DroidComparator<>();

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < queue.size();
            }

            @Override
            public E next() {
                return queue.get(index++);
            }
        };
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean addAll(Collection<E> collection){
        boolean modified = false;
        for (E temp : collection){
            modified = offer(temp);
        }
        return modified;
    }

    public boolean offer(E e){
        boolean modified = false;
        if (queue.size() == 0){
            queue.add(e);
            modified = true;
        }else{
            for (int i = 0; i < queue.size(); i++){
                E current = queue.get(i);
                if (comparator.compare(current,e) == 1){
                    queue.add(i,e);
                    modified = true;
                    break;
                }
            }
        }
        if (!modified) {
            queue.add(e);
            modified = true;
        }
        return modified;
    }

    public E poll(){
        E e;
        if (queue.size() == 0){
            e = null;
        }else{
            e = queue.remove(0);
        }
        return e;
    }

    public E peek(){
        E e;
        if (queue.size() == 0){
            e = null;
        }else {
            e = queue.get(0);
        }
        return e;
    }

    public String toString(){
        return queue.toString();
    }
}
