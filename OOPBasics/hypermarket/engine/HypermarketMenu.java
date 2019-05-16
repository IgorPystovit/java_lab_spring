package growepam.hypermarket.engine;

import growepam.Menu;
import growepam.hypermarket.products.Product;
import growepam.hypermarket.products.sanitaryengineering.FlooringTile;
import growepam.hypermarket.products.sanitaryengineering.WashStand;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.products.woodenfurniture.Bookcase;
import growepam.hypermarket.products.woodenfurniture.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//This class represents Hypermarket meny which consists of main hypermarket manager functions
public class HypermarketMenu implements Menu {
    private static Scanner scan = new Scanner(System.in);

    //reads user request from console and gives string with request to excecuteRequest method
    @Override
    public void menu(){
        String request = "";
        System.out.println("Welcome to hypermarket product manager");
        do{
            System.out.println("\n Available reuqests:" +
                    "\n - Show products (to show all products);" +
                    "\n - Form recommendations (to form recommendation list based on your previlleges);" +
                    "\n - Exit (to exit hypermarket product manager);\n");
            System.out.println("Type your reqest below:");
            request = scan.nextLine().toUpperCase();
            executeRequest(request);
        }while (!request.equals("EXIT"));
    }

    //takes string with request as method parameter and calls mathod depending on request string content
    private void executeRequest(String request){
        switch (request){
            case "SHOW PRODUCTS":
                ProductManager.printCollection(ProductManager.getProductSet());
                break;
            case "FORM RECOMMENDATIONS":
                ProductManager.printCollection(listMaker());
            case "EXIT":
                return;
            default:
                System.out.println("No such request! Please retry!");
        }
    }

    //froms list of recommendations based on user privilleges
    private Set<Product> listMaker(){
        Set<Product> recommendations = new HashSet<>();
        ProductType productType;
        System.out.println("Input product type (Required field):");

        productType = Reader.readProductType();
        if (productType == null){
            System.out.println("You have entered no product type!");
            recommendations = Collections.emptySet();
        }

        switch (productType){
            case TILE:
                recommendations = applySelector(new FlooringTile());
                break;
            case WASHSTAND:
                recommendations = applySelector(new WashStand());
                break;
            case BOOKCASE:
                recommendations = applySelector(new Bookcase());
                break;
            case TABLE:
                recommendations = applySelector(new Table());
                break;
            default:
                System.out.println("No such product type");

        }

        return recommendations;
    }

    private Set<Product> applySelector(Product product){
        return product.selector();
    }

}
