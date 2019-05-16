package growepam.airline;

import growepam.airline.plane.Plane;
import growepam.airline.plane.PlaneManager;

import java.util.*;

public class Airline {
    private static Scanner scan = new Scanner(System.in);
    private String name;
    private Set<Plane> planes = new LinkedHashSet<>();

    public Airline(){}
    public Airline(String name, Set<Plane> planes){
        this.planes = planes;
        this.name = name;
    }

    public static Airline create(){
        String airlineName;
        Set<Plane> planes;
        System.out.println("Input name of your airline");
        System.out.println("Name:");
        airlineName = scan.nextLine();
        System.out.println("Create a list of the aircraft of which the airline consists");
        planes = createAircraft();
        return new Airline(airlineName,planes);
    }

    private static Set<Plane> createAircraft(){
        Set<Plane> planes = new LinkedHashSet<>();
        String request;
        do{
            System.out.println("List of requests:\n" +
                    "- Show all (to print all available planes);\n" +
                    "- Add (to add plane existing on the list);\n" +
                    "- Add myself (to add plane created by yourself);\n" +
                    "- Remove (to remove plane from aircraft list);\n" +
                    "- Print aircraft (to print all planes added to aircraft list);\n" +
                    "- Exit (to finish creation process);\n");
            System.out.println("Type your request:");
            request = scan.nextLine().toUpperCase();
            String planeName;
            Plane tempPlane;
            switch (request){
                case "SHOW ALL":
                    PlaneManager.printCollection(PlaneManager.getPlaneSet());
                    break;
                case "PRINT AIRCRAFT":
                    PlaneManager.printCollection(planes);
                    break;
                case "ADD":
                    System.out.println("Input name of plane to add");
                    planeName = scan.nextLine().toUpperCase();
                    tempPlane = PlaneManager.getPlaneByName(planeName);
                    if (tempPlane == null){
                        continue;
                    }
                    if (planes.add(tempPlane)){
                        System.out.println("Added!");
                    }
                    break;
                case "ADD MYSELF":
                    tempPlane = Plane.create();
                    if (planes.add(tempPlane)){
                        System.out.println("Added!");
                    }
                    break;
                case "REMOVE":
                    System.out.println("Input name of plane to remove");
                    planeName = scan.nextLine().toUpperCase();
                    tempPlane = PlaneManager.getPlaneByName(planeName);
                    if (tempPlane == null){
                        continue;
                    }
                    if (planes.remove(tempPlane)){
                        System.out.println("Removed!");
                    }
                    break;
                case "EXIT":
                    if (planes.size() == 0){
                        System.out.println("There is no planes on the list! Please add some!");
                        continue;
                    }else{
                        return planes;
                    }
                default:
                    System.out.println("No such request please retry!");
            }
        }while (true);
    }

    public String getName() {
        return name;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanes(Collection<Plane> planes) {
        this.planes = new LinkedHashSet<>(planes);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nAirline: ").append(name).append('\n');
        sb.append("\nPLANES\n\n");
        for (Plane tempPlane : planes){
            sb.append(tempPlane).append('\n');
        }
        return sb.toString();
    }

}

