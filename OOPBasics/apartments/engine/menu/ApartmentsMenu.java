package growepam.apartments.engine.menu;

import growepam.Menu;
import growepam.apartments.engine.requestperformers.RequestHandler;
import growepam.apartments.engine.requestperformers.listmaker.Parameters;
import growepam.apartments.estatemanagers.RealEstateManager;
import growepam.apartments.realestate.RealEstate;
import growepam.apartments.engine.requestperformers.listmaker.RecommendationListMaker;
import growepam.apartments.engine.requestperformers.sorter.EstateSorter;
import growepam.apartments.engine.sortparameters.SortParameter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//This class represents apartments menu
public class ApartmentsMenu implements Menu {
    private Scanner scan = new Scanner(System.in);
    private RealEstateManager estateManager = new RealEstateManager();

    //Invokes method according to user request
    @Override
    public void menu(){
        List<RealEstate> customEstateList;
        System.out.println("Welcome to real estate manager system");
        System.out.println("Please, type your request below");
        String request;
        do{
            System.out.println("Available requests:\n" +
                    "- Show all (to show all estate available);\n" +
                    "- Sort (to sort all available estate or certain type of estate by certain sort parameter);\n" +
                    "- Form recommendations (to form recommendation list based on your privileges;\n" +
                    "- Exit (to exit program)\n");
            request = scan.nextLine().toUpperCase();
            switch (request){
                case "SHOW ALL":
                    customEstateList = estateManager.getEstateList();
                    break;
                case "SORT":
                    System.out.println("\nPlease select sort parameter");
                    System.out.println("Available sort parameters:\n" +
                            " - price;\n" +
                            " - distance (to infrastructure object);\n" +
                            " - area;\n");
                    SortParameter sortParameter = Parameters.sortParameterReader();
                    customEstateList = applyRequest(new EstateSorter(sortParameter));
                    break;
                case "FORM RECOMMENDATIONS":
                    customEstateList = applyRequest(new RecommendationListMaker());
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request! Please retry later");
                    customEstateList = Collections.emptyList();
            }
            printCollection(customEstateList);
        }while (true);

    }

    private <T> void printCollection(Collection<T> estateList){
        if (estateList.size() == 0){
            System.out.println("Nothing on the list");
        }else{
            for (T tempEstate : estateList){
                System.out.println(tempEstate);
            }
        }
    }

    private List<RealEstate> applyRequest(RequestHandler requestHandler){
        return requestHandler.performRequest();
    }
}
