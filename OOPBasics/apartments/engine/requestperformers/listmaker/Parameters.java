package growepam.apartments.engine.requestperformers.listmaker;

import growepam.apartments.engine.sortparameters.SortParameter;
import growepam.apartments.realestatetypes.EstateType;
import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.infrastructure.InfrastructureObjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This class represents sort parameters
//It also consist of methods for reading data in the safe way
//By using recovery system we making sure that user is not able to input data of wrong type
//All methods have common semantic but different return types and informational messages to print
public class Parameters {
    private double customArea;
    private String customPrice;
    private EstateType customEstateType;
    private List<InfrastructureObject> customInfrastructureObjectList = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public double getCustomArea() {
        return customArea;
    }

    public EstateType getCustomEstateType() {
        return customEstateType;
    }

    public List<InfrastructureObject> getCustomInfrastructureObjectList() {
        return customInfrastructureObjectList;
    }

    public double getCustomPrice() {
        double priceValue = 0.0;
        if (customPrice.equals("")){
            return priceValue;
        }
        try{
            priceValue = Math.abs(Double.parseDouble(customPrice));
        } catch (NumberFormatException e){
            return 0.0;
        }
        return priceValue;
    }

    private void estateTypeReader(){
        do{
            try {
                System.out.println("\nPlease enter estate type you are intrested in. This field is required!!!");
                System.out.println("Available estate types:");
                for (EstateType e : EstateType.values()){
                    System.out.println("- "+e.toString().toLowerCase()+";");
                }
                customEstateType = EstateType.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("You have entered wrong type value! Please retry!");
                continue;
            }
            break;
        }while (true);
    }

    private void priceReader(){
        System.out.println("\nPlease enter price of "+customEstateType.toString().toLowerCase()+"(Press Enter to ignore)");
        do{
            try{
                customPrice = scan.nextLine();
                if (customPrice.equals("")){
                    return;
                }
                Double.parseDouble(customPrice);
            } catch (NumberFormatException e){
                System.out.println("Wrong value! Please retry!");
                continue;
            }
            break;
        }while (true);
    }

    private void areaReader(){
        do{
            try{
                System.out.println("\nPlease enter area of "+customEstateType.toString().toLowerCase()+" (Press Enter to ignore)");
                String stringCustomArea = scan.nextLine();
                if (stringCustomArea.equals("")){
                    customArea = 0.0;
                    return;
                }
                customArea = Math.abs(Double.parseDouble(scan.nextLine()));
            } catch (NumberFormatException e){
                System.out.println("Wrong value! Please retry!");
                continue;
            }
            break;
        }while (true);
    }

    private void infrastructureObjectsReader(){
        System.out.println("\nWould you like to add a description of infrastructure objects to be nearby the property?(Type Yes/No)");
        String responseListener = scan.nextLine();
        InfrastructureObjectType objectType = null;
        double distance = 0.0;
        while (responseListener.toUpperCase().equals("YES")){
            InfrastructureObject infrastructureObject = new InfrastructureObject();

            //ObjectType recovery system
            do{
                try{
                    System.out.println("\nEnter type of object");
                    System.out.println("Available object types:");
                    for (InfrastructureObjectType temp : InfrastructureObjectType.values()){
                        System.out.println("- "+ temp.toString().toLowerCase()+";");
                    }
                    objectType = InfrastructureObjectType.valueOf(scan.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong object type! Please retry!");
                    continue;
                }
                infrastructureObject.setInfrastructureObjectType(objectType);
                break;
            }while (true);

            //distanceReader recovery system
            do{
                try{
                    System.out.println("Enter distance to object");
                    distance = Double.parseDouble(scan.nextLine());
                } catch (NumberFormatException e){
                    System.out.println("Wrong value! Please retry!");
                    continue;
                }
                infrastructureObject.setDistance(distance);
                break;
            }while (true);

            customInfrastructureObjectList.add(infrastructureObject);
            System.out.println("\nWould you like to add one more?");
            responseListener = scan.nextLine();
        }
    }

    public static SortParameter sortParameterReader(){
        SortParameter sortParameter;
        do{
            try{
                sortParameter = SortParameter.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Wrong type of sort parameter was entered! Please retry!");
                continue;
            }
            break;
        }while (true);
        return sortParameter;
    }

    //Invokes set of data reader methods
    public void read(){
        estateTypeReader();
        priceReader();
        areaReader();
        infrastructureObjectsReader();
    }
}
