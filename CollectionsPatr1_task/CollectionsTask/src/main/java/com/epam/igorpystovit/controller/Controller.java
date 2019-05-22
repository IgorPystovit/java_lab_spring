package com.epam.igorpystovit.controller;

import com.epam.igorpystovit.model.droidPriorityQueue.DroidPriorityQueue;
import com.epam.igorpystovit.model.droidPriorityQueue.PriorityDroidsShip;
import com.epam.igorpystovit.model.shipwithdroids.Droid;
import com.epam.igorpystovit.model.shipwithdroids.DroidType;
import com.epam.igorpystovit.model.shipwithdroids.Ship;
import com.epam.igorpystovit.view.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Controller {
    private static final Ship<Droid> SHIP = new Ship<>();
    private static final Scanner scan = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());
    private static final PriorityDroidsShip<Droid> PRIORITY_DROIDS_SHIP = new PriorityDroidsShip<>();


    public void putDroid(Droid droid){
        SHIP.putDroid(droid);
    }

    public Droid createDroid(){
        return Droid.create();
    }

    public void printDroidTypes(){
        Arrays.stream(DroidType.values()).map(a -> a.toString().toLowerCase()).forEach(a -> System.out.println("-"+a));
    }

    public DroidPriorityQueue<Droid> getPriorityDroidsOnBoard(){
        return PRIORITY_DROIDS_SHIP.getPriorityDroidsOnBoard();
    }

    public Droid getDroidByName(Collection<Droid> droids){
        Scanner scan = new Scanner(System.in);
        Droid neededDroid = null;
        System.out.println("Input droid model");
        try{
            String droidModel = scan.nextLine();
            String finalDroidModel = droidModel;
            neededDroid = droids.stream()
                    .filter(a -> a.getModel().equals(finalDroidModel))
                    .findFirst()
                    .get();
        }catch (NoSuchElementException e){
            System.out.println("There is no such droid");
            LOGGER.error("No such droid");
        }
        return neededDroid;
    }

    public void putPriorityDroid(Droid droid){
         PRIORITY_DROIDS_SHIP.putPriorityDroid(droid);
    }

    public void printPriorityDroids(){
        PRIORITY_DROIDS_SHIP.printPriorityDroids();
    }

    public Droid removePriorityDroid(){
        return PRIORITY_DROIDS_SHIP.removeDroid();
    }

    public List<Droid> getDroidsOnBoard(){
        return SHIP.getDroidsOnBoard();
    }

    public void putDroids(Collection<Droid> droids){
        SHIP.putDroids(droids);
    }

    public void printDroidsOnBoard(){
        SHIP.printDroids();
    }

    public void removeDroid(Droid droid){
        SHIP.removeDroid(droid);
    }

    public void printResult(Printable printable){
        printable.print();
    }

    public String scanRequest(){
        return scan.nextLine().toUpperCase();
    }


}
