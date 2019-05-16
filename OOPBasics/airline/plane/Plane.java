package growepam.airline.plane;

import growepam.airline.airlineengine.Reader;

import java.util.Scanner;

//This class represents Plane
//It includes plane attributes
//Also it includes creator method which allows to create plane with given parameters
public class Plane implements Comparable<Plane>{
    private static Scanner scan = new Scanner(System.in);
    private String name;
    private double fuelConsumption;
    private double loadCapacity;
    private double flightRange;
    private double passengerCapacity;
    private PlaneType planeType;

    public Plane(){}
    public Plane(String name, PlaneType planeType, double fuelConsumption, double loadCapacity, double flightRange, double passengerCapacity){
        this.name = name;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.loadCapacity = loadCapacity;
        this.passengerCapacity = passengerCapacity;
        this.planeType = planeType;
    }

    @Override
    public int compareTo(Plane o){
        int compareNum = 0;

        if (this.flightRange < o.flightRange){
            compareNum = -1;
        } else if (this.flightRange > o.flightRange){
            compareNum = 1;
        }

        return compareNum;
    }

    //Invokes different data reader methods in order to fill all fields required for plane creation
    public static Plane create(){
        Plane customPlane;
        String customName;
        double customFuelConsumption;
        double customLoadCapacity;
        double customFlightRange;
        double customPassengerCapacity;
        PlaneType customPlaneType;
        System.out.println("Input necessary parameters for plane creation");
        System.out.println("Name of plane:");
        customName = scan.nextLine();
        if (!PlaneManager.checkIfAbsent(customName)){
            System.out.println("Plane with this name is present on the list");
            return PlaneManager.getPlaneByName(customName);
        }
        System.out.println("Fuel consumption (kg/h):");
        customFuelConsumption = Reader.readDouble();
        System.out.println("Load capacity (tons):");
        customLoadCapacity = Reader.readDouble();
        System.out.println("Flight range (km):");
        customFlightRange = Reader.readDouble();
        System.out.println("Passenger capacity:");
        customPassengerCapacity = Reader.readDouble();
        System.out.println("Plane type:");
        System.out.println("Available types:");
        for (PlaneType temp : PlaneType.values()){
            System.out.println("- "+temp.toString().toLowerCase()+";");
        }
        customPlaneType = Reader.readPlaneType();
        customPlane = new Plane(customName,customPlaneType,customFuelConsumption,customLoadCapacity,customFlightRange,customPassengerCapacity);
        return customPlane;
    }

    public String getName() {
        return name;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public double getPassengerCapacity() {
        return passengerCapacity;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Plane: ").append(name.toLowerCase()).append('\n');
        sb.append("Type: ").append(planeType.toString().toLowerCase()).append(";\n");
        sb.append("Fuel consumption: ").append(fuelConsumption).append(" kg/h;\n");
        sb.append("Flight range: ").append(flightRange).append(" km;\n");
        sb.append("Load capacity: ").append(loadCapacity).append(" tons;\n");
        sb.append("Passenger capacity: ").append(passengerCapacity).append(";\n");
        return sb.toString();
    }
}
