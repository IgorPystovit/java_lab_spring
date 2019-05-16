package growepam.gemstones.product;

import growepam.gemstones.component.Component;
import growepam.gemstones.gemstone.Gemstone;
import growepam.gemstones.gemstone.GemstoneManager;

import java.util.*;

//This class represnts Product object
//It consists of name attribute and set of components
//It also includes creator method that provides basic features of product creating
public class Product {
    private static Scanner scan = new Scanner(System.in);
    private Set<Component> components;
    private String name;

    public Product(){}
    public Product(String name){
        this.name = name;
        components = new LinkedHashSet<>();
    }

    public void creator(){
        String request = "";

        do{
            System.out.println("\nThis requests will help you in creating your own product:\n" +
                    "- Show all (to show all available gemstones);\n" +
                    "- Add component (to add gemstone to component list of product);\n" +
                    "- Show current (to show all components currently present on the components list);\n" +
                    "- Remove component (to remove gemstone from component list of product);\n" +
                    "- Exit (to exit product creating process);\n");
            System.out.println("Type your request");
            request = scan.nextLine().toUpperCase();
            switch (request){
                case "ADD COMPONENT":
                    if (addComponent()){
                        System.out.println("Added!");
                    }
                    break;
                case "REMOVE COMPONENT":
                    if (removeComponent()){
                        System.out.println("Removed!");
                    }else{
                        System.out.println("There is no such object present on the component list\n");
                    }
                    break;
                case "SHOW CURRENT":
                    GemstoneManager.printCollection(components);
                    break;
                case "SHOW ALL":
                    GemstoneManager.printCollection(GemstoneManager.getGemstonesList());
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request! Please retry!!!");
            }
        }while (true);

    }

    //adds new component to component set
    //if such component is already presented on the list, then it calculates weight of two components altogether
    //If new component was added to list successfully returns true
    //In other case returns false
    private boolean addComponent(){
        boolean modified = false;
        Component component = Component.componentCreator();
        if (component.getGemstone() == null){
            return modified;
        }
        //check if such component presented on the list
        for (Component tempComponent : components) {
            //if so calculate their weight altogether
            if (tempComponent.equals(component)) {
                tempComponent.addWeight(component.getWeight());
                return modified;
            }
        }

        components.add(component);
        modified = true;
        return modified;
    }

    //removes component from the list by name of its gemstone
    //If component was removed from list successfully returns true
    //In other case returns false
    private boolean removeComponent(){
        boolean modified = false;
        System.out.println("Input name of gemstone to delete");
        Gemstone gemstoneToDelete = Reader.gemstoneReader();

        for (Component tempComponent : new LinkedHashSet<>(components)){
            String tempGemstoneName = tempComponent.getGemstone().getName();
            if (tempGemstoneName.equals(gemstoneToDelete.getName())){
                components.remove(tempComponent);
                modified = true;
                break;
            }
        }

        return modified;
    }

    public String getName() {
        return name;
    }

    public Set<Component> getComponents() {
        return components;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n-----Product name: ").append(name).append("----\n");
        for (Component tempComponent : components){
            sb.append(tempComponent);
        }
        if (components.size() == 0){
            sb.append("There is no product copmonents\n");
        }
        return sb.toString();
    }
}
