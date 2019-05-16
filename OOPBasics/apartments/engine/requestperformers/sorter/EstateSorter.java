package growepam.apartments.engine.requestperformers.sorter;

import growepam.apartments.infrastructure.InfrastructureObjectType;
import growepam.apartments.realestate.RealEstate;
import growepam.apartments.estatemanagers.RealEstateManager;
import growepam.apartments.engine.requestperformers.RequestHandler;
import growepam.apartments.engine.sortparameters.SortParameter;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

//This class represents estate sorter
//It consists of methods that provide sorting based on given parameter
public class EstateSorter implements RequestHandler {
    private SortParameter sortParameter;
    private Scanner scan = new Scanner(System.in);
    private RealEstateManager realEstateManager = new RealEstateManager();

    public EstateSorter(){}
    public EstateSorter(SortParameter sortParameter){
        this.sortParameter = sortParameter;
    }

    //invokes sorter method according to given parameter
    public List<RealEstate> performRequest(){
        List<RealEstate> realEstateList = new LinkedList<>();
        switch (sortParameter) {
            case AREA:
                realEstateList = sortByArea(realEstateManager.getEstateList());
                break;
            case PRICE:
                realEstateList = sortByPrice(realEstateManager.getEstateList());
                break;
            case DISTANCE:
                System.out.println("Please enter type of object\n");
                InfrastructureObjectType objectType;

                do{
                    try{
                        System.out.println("Available object types:");
                        for (InfrastructureObjectType temp : InfrastructureObjectType.values()){
                            System.out.println("- "+temp.toString().toLowerCase()+";");
                        }
                        objectType = InfrastructureObjectType.valueOf(scan.next().toUpperCase());
                    } catch (IllegalArgumentException e){
                        System.out.println("You've entered object of wrong type! Please retry");
                        continue;
                    }
                    break;
                }while (true);

                realEstateList = sortByDistanceToObject(objectType,realEstateManager.getEstateList());
                break;
            default:
                realEstateList.clear();
        }
        return realEstateList;
    }

    private List<RealEstate> sortByDistanceToObject(InfrastructureObjectType infrastructureObjectType, List<RealEstate> realEstateList){
        //remove real estate object from list if it does not have infrastructure object of specified type placed nearby
        for (RealEstate iTempEstate : new LinkedList<>(realEstateList)){
            if (iTempEstate.getDistanceToObject(infrastructureObjectType) == 0.0){
                realEstateList.remove(iTempEstate);
            }
        }

        RealEstate[] realEstateArray = realEstateList.toArray(new RealEstate[0]);
        for (int i = 0; i < realEstateArray.length; i++){
            for (int j = 0; j < realEstateArray.length - 1; j++){
                if (realEstateArray[j].getDistanceToObject(infrastructureObjectType) > realEstateArray[j+1].getDistanceToObject(infrastructureObjectType)){
                    RealEstate tempEstate = realEstateArray[j];
                    realEstateArray[j] = realEstateArray[j+1];
                    realEstateArray[j+1] = tempEstate;
                }
            }
        }
        realEstateList.clear();
        realEstateList.addAll(Arrays.asList(realEstateArray));
        return realEstateList;
    }

    private List<RealEstate> sortByPrice(List<RealEstate> realEstateList){
        RealEstate[] realEstateArray = realEstateList.toArray(new RealEstate[0]);
        for (int i = 0; i < realEstateArray.length; i++){
            for (int j = 0; j < realEstateArray.length - 1; j++){
                if (realEstateArray[j].getPrice() > realEstateArray[j+1].getPrice()){
                    RealEstate tempEstate = realEstateArray[j];
                    realEstateArray[j] = realEstateArray[j+1];
                    realEstateArray[j+1] = tempEstate;
                }
            }
        }
        realEstateList.clear();
        realEstateList.addAll(Arrays.asList(realEstateArray));
        return realEstateList;
    }

    private List<RealEstate> sortByArea(List<RealEstate> realEstateList){
        RealEstate[] realEstateArray = realEstateList.toArray(new RealEstate[0]);
        for (int i = 0; i < realEstateArray.length; i++){
            for (int j = 0; j < realEstateArray.length-1; j++){
                if (realEstateArray[j].getArea() > realEstateArray[j+1].getArea()){
                    RealEstate tempEstate = realEstateArray[j];
                    realEstateArray[j] = realEstateArray[j+1];
                    realEstateArray[j+1] = tempEstate;
                }
            }
        }
        realEstateList.clear();
        realEstateList.addAll(Arrays.asList(realEstateArray));
        return realEstateList;
    }
}
