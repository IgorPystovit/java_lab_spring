package com.epam.igorpystovit.model.shipwithdroids;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ship<T extends Droid> {
    private List<T> droidsOnBoard = new LinkedList<>();
    private Logger logger = LogManager.getLogger(Ship.class.getName());

    public void putDroid(T droid){
        if (droidsOnBoard.add(droid)){
            System.out.println("Droid has been put");
            logger.info("Droid has been put");
        }else{
            System.out.println("Droid has not been put");
            logger.info("Droid has not been put");
        }
    }

    public void printDroids(){
        if (droidsOnBoard.size() == 0){
            System.out.println("There are no droids on the board");
            logger.info("No droids on the board");
        }
        droidsOnBoard.forEach(System.out::println);
    }

    public void putDroids(Collection<T> droids){
        if (droidsOnBoard.addAll(droids)){
            System.out.println("Droids have been put");
            logger.info("Droids have been put");
        }else{
            System.out.println("Droids have not been put");
            logger.info("Droids have not been put");
        }
    }

    public List<T> getDroidsOnBoard(){
        if (droidsOnBoard.size() == 0){
            logger.info("There are no droids on board");
        }
        return droidsOnBoard;
    }

    public void removeDroid(T droid){
        if(droidsOnBoard.removeAll(Collections.singleton(droid))){
            System.out.println("Droid has been removed");
            logger.info("Droid has been removed");
        }else{
            System.out.println("Droid has not been removed");
            logger.info("Droid has not been removed");
        }
    }

}
