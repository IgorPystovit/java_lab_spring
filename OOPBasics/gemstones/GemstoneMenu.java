package growepam.gemstones;

import growepam.Menu;
import growepam.gemstones.gemstone.GemstoneManager;
import growepam.gemstones.product.Product;
import growepam.gemstones.product.ProductEvaluator;

import java.util.*;

//This class represents GemstoneMenu
//It also provides basic methods for creating, saving, and printing user created products
public class GemstoneMenu implements Menu{
    private static Scanner scan = new Scanner(System.in);
    private ProductEvaluator productEvaluator = new  ProductEvaluator();
    @Override
    public void menu(){
        String request;
        Product product = null;
        System.out.println("Welcome to precious stones manager");
        System.out.println("Choose request from list below");

        do{
            System.out.println("Available requests:\n" +
                    "- Create new product (to choose stones from list for creating product of your own);\n" +
                    "- Show all (to print list of stones of all types;\n" +
                    "- Print product (to print product name and its components);\n" +
                    "- Evaluate (to invoke product evaluator);\n" +
                    "- Exit (to exit the manager);\n");
            System.out.println("Type your request");
            request = scan.nextLine().toUpperCase();
            switch (request){
                case "CREATE NEW PRODUCT":
                    System.out.println("Please, type name of your product:");
                    String productName = scan.nextLine();
                    product = new Product(productName);
                    product.creator();
                    break;
                case "PRINT PRODUCT":
                    if (product != null){
                        System.out.println(product);
                    }else{
                        System.out.println("There is no product!");
                    }
                    break;
                case "EVALUATE":
                    productEvaluator.evaluate(product);
                    break;
                case "SHOW ALL":
                    GemstoneManager.printCollection(GemstoneManager.getGemstonesList());
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request! Please retry");
            }
        }while (true);
    }
}
