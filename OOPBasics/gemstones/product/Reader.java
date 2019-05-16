package growepam.gemstones.product;

import growepam.gemstones.gemstone.Clarity;
import growepam.gemstones.gemstone.Gemstone;
import growepam.gemstones.gemstone.GemstoneManager;

import java.util.Scanner;

///This class implements methods for reading data in the safe way
//By using recovery system we making sure that user is not able to input data of wrong type
//All methods have common semantic but different return types and informational messages to print
public class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static Clarity readClarity(){
        Clarity clarity;
        do{
            try{
                System.out.println("Available clarity types:");
                for (Clarity temp : Clarity.values()){
                    System.out.println("- "+temp.toString().toLowerCase()+";");
                }
                System.out.println("Clarity value:");
                clarity = Clarity.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("You have entered wrong clarity value! Please retry!");
                continue;
            }
            break;
        } while (true);
        return clarity;
    }

    public static double weightReader(){
        double weight = 0.0;
        do{
            try{
                System.out.println("Gemstone weight (miligrams):");
                weight = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e){
                System.out.println("You have entered wrong weight value please retry!!!");
                continue;
            }
            break;
        }while (true);

        return weight;
    }

    //Reads name of gemstone and checks if gemstone with such name presented on the list
    //If so returns this gemstone
    //If not repeat process described above
    //If users input is equal to "EXIT" returns null
    public static Gemstone gemstoneReader(){
        String gemstoneName = "";
        Gemstone gemstone = null;
        do{
            System.out.println("Gemstone name:");
            gemstoneName = scan.nextLine().toUpperCase();
            gemstone = GemstoneManager.getGemstoneByName(gemstoneName);
            if ((gemstone != null) || (gemstoneName.toUpperCase().equals("EXIT"))){
                break;
            }
        }while (true);
        return gemstone;
    }
}
