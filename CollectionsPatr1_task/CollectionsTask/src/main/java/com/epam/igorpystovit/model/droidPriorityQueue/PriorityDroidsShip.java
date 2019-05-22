package com.epam.igorpystovit.model.droidPriorityQueue;

import com.epam.igorpystovit.model.shipwithdroids.Droid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

public class PriorityDroidsShip<T extends Droid> {
    private DroidPriorityQueue<T> droidsOnBoard = new DroidPriorityQueue<>();
    private Logger logger = LogManager.getLogger(PriorityDroidsShip.class.getName());

    public void putPriorityDroid(T droid){
        if (droidsOnBoard.offer(droid)){
            System.out.println("Priority droid has been put");
            logger.info("Priority droid has been put");
        }else{
            System.out.println("Priority droid has not been put");
            logger.info("Priority droid has not been put");
        }
    }

    public void printPriorityDroids(){
        Iterator iterator = droidsOnBoard.iterator();
        if (droidsOnBoard.size() == 0){
            System.out.println("There are no droids on the board");
            logger.info("No droids on the board");
        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public DroidPriorityQueue<T> getPriorityDroidsOnBoard(){
        if (droidsOnBoard.size() == 0){
            logger.info("There are no priority droids on board");
        }
        return droidsOnBoard;
    }

    public T removeDroid(){
        T removedDroid = droidsOnBoard.poll();
        if(removedDroid != null){
            System.out.println("Droid has been removed");
            logger.info("Droid has been removed");
        }else{
            System.out.println("Droid has not been removed");
            logger.info("Droid has not been removed");
        }
        return removedDroid;
    }


}
