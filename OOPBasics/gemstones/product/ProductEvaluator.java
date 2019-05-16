package growepam.gemstones.product;

import growepam.gemstones.gemstone.Gemstone;
import growepam.gemstones.product.Product;
import growepam.gemstones.component.Component;
import growepam.gemstones.gemstone.Clarity;
import growepam.gemstones.gemstone.GemstoneManager;
import growepam.gemstones.product.Reader;
import growepam.hypermarket.engine.ProductManager;

import java.util.*;

//This class is product evaluator representation
//It consists only of evaluation mathods
public class ProductEvaluator {

    //Invokes evaluation method according to user request
    public void evaluate(Product product){
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Available evaluator requests:\n" +
                    "- Evaluate price (to evaluate price of all gemstones in product);\n" +
                    "- Evaluate weight (to evaluate weight in carats of all gemstones in product);\n" +
                    "- Sort (to sort gemstones by price in ascending order);\n" +
                    "- Select by clarity (to select all of the gemstones that correspond defined clarity parameter);\n" +
                    "- Exit (to exit product evaluator);\n");
            System.out.println("Type your request:");
            String request = scan.nextLine().toUpperCase();
            switch (request){
                case "EVALUATE PRICE":
                    evaluatePrice(product.getComponents());
                    break;
                case "EVALUATE WEIGHT":
                    evaluateWeightInCarats(product.getComponents());
                    break;
                case "SORT":
                    ProductManager.printCollection(sortByPrice(product.getComponents()));
                    break;
                case "SELECT BY CLARITY":
                    Clarity userClarity = Reader.readClarity();
                    Collection<Component> selectedByClarity = selectByClarity(product.getComponents(),userClarity);
                    GemstoneManager.printCollection(selectedByClarity);
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request! Please retry!");
            }
        }while (true);

    }

    private void evaluatePrice(Collection<Component> components){
        double totalPrice = 0.0;
        for (Component tempComponent : components){
            totalPrice += tempComponent.getGemstone().getPrice() * (tempComponent.getWeight() / 200);
        }
        System.out.println("Total price: "+totalPrice+"$\n");
    }

    private void evaluateWeightInCarats(Collection<Component> components){
        double totalWeightInCarats = 0.0;
        for (Component tempComponent : components){
            totalWeightInCarats += tempComponent.getWeight() / 200;
        }
        System.out.println("Total weight: "+totalWeightInCarats+" carats\n");
    }

    //sorts components of prodect by their price with quick sort
    private Collection<Gemstone> sortByPrice(Collection<Component> components){
        if ((components.size() == 0) || (components == null)){
            System.out.println("There is nothing on the list");
        }

        List<Gemstone> gemstones = new ArrayList<>();

        for (Component component : components){
            gemstones.add(component.getGemstone());
        }
        Collections.sort(gemstones);
        return gemstones;
    }


    private Collection<Component> selectByClarity(Collection<Component> components, Clarity clarity){
        List<Component> gemstonesByClarity = new LinkedList<>();

        if ((components.size() == 0) || (components == null)){
            System.out.println("There is nothing on the list");
        }
        if (clarity == null){
            System.out.println("There is no specified clarity");
            return null;
        }

        for (Component tempComponent : new ArrayList<>(components)){
            if (tempComponent.getGemstone().getClarity().equals(clarity)){
                gemstonesByClarity.add(tempComponent);
            }
        }
        if (gemstonesByClarity.size() == 0){
            System.out.println("There is no gemstones of such clarity");
        }
        return gemstonesByClarity;
    }
}
