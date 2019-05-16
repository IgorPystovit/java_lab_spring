package growepam.airline.plane;

import java.util.*;

//This class represents plane manager
//It consists of set of planes of different types and additional mathods
public class PlaneManager {
    private static Set<Plane> planes = new HashSet<>(Arrays.asList(
            new Plane("AN-148", PlaneType.PASSENGER,1550,9.6,3500,80),
            new Plane("AIRBUS-220",PlaneType.PASSENGER,2500,20,5400,120),
            new Plane("BOEING-717",PlaneType.PASSENGER,1800,15,6850,156),
            new Plane("BOEING-777",PlaneType.PASSENGER,6700,40,10200,550),
            new Plane("IL-86",PlaneType.PASSENGER,4300,32,5250,350),
            new Plane("AIRBUS-380",PlaneType.PASSENGER,7000,83,13100,700),
            new Plane("AIRBUS-BELUGA",PlaneType.CARGO,13000,47,3000,20),
            new Plane("AN-225",PlaneType.CARGO,15900,200,5000,90),
            new Plane("BOEING-DREAMLIFTER",PlaneType.CARGO,13500,113,7800,10),
            new Plane("BOEING-GLOBEMASTER",PlaneType.CARGO,10100,77,4500,150)));

    //Returns set of planes of different types
    public static Set<Plane> getPlaneSet(){
        return planes;
    }

    //Returns set of planes of specified type
    public static Set<Plane> getPlaneSet(PlaneType planeType){
        Set<Plane> planeSet = new HashSet<>();
        for (Plane tempPlane : planes){
            if (tempPlane.getPlaneType().equals(planeType)){
                planeSet.add(tempPlane);
            }
        }
        return planeSet;
    }


    public static <T> void printCollection(Collection<T> collection){
        if (collection.size() == 0){
            System.out.println("Nothing on the list");
            return;
        }
        for (T temp : collection){
            System.out.println(temp);
        }
    }

    //Returns plane of specified name if it is presented on the list
    //If not returns null
    public static Plane getPlaneByName(String name){
        Plane plane = null;
        if (checkIfAbsent(name)){
            System.out.println("No plane with such name");
        }else{
            for (Plane tempPlane : planes){
                if (tempPlane.getName().equals(name)){
                    plane = tempPlane;
                    break;
                }
            }
        }
        return plane;
    }

    //Checks if plane with specified name is presented on the list
    //if so returns true
    //else returns false
    public static boolean checkIfAbsent(String planeName){
        boolean isAbsent = true;
        for (Plane tempPlane : planes){
            if (tempPlane.getName().equals(planeName)){
                isAbsent = false;
                break;
            }
        }
        return isAbsent;
    }
}
