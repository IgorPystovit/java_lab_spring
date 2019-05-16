package growepam.airline.airlineengine;

import growepam.airline.plane.PlaneType;

import java.util.Scanner;

///This class implements methods for reading data in the safe way
//By using recovery system we making sure that user is not able to input data of wrong type
//All methods have common semantic but different return types and informational messages to print
public class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static double readDouble(){
        double doubleValue = 0.0;

        do{
            try{
                doubleValue = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Wrong value! Please retry!");
                continue;
            }
            break;
        }while (true);

        return doubleValue;
    }

    public static PlaneType readPlaneType(){
        PlaneType planeType;

        do{
            try {
                planeType = PlaneType.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Wrong plane type! Please retry!");
                continue;
            }
            break;
        }while (true);
        return planeType;
    }
}
