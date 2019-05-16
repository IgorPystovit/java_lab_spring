package growepam.hypermarket.engine;

import growepam.hypermarket.products.Product;
import growepam.hypermarket.products.sanitaryengineering.FlooringTile;
import growepam.hypermarket.products.sanitaryengineering.WashStand;
import growepam.hypermarket.tuningparameters.Color;
import growepam.hypermarket.tuningparameters.Material;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.tuningparameters.Shape;
import growepam.hypermarket.products.woodenfurniture.Bookcase;
import growepam.hypermarket.products.woodenfurniture.Table;

import java.util.*;
//This class consists of sets of different type products and several methods
public class ProductManager  {
    private static Set<WashStand> washStandSet = new HashSet<>(Arrays.asList(
            new WashStand("Braviken Wash", Color.RED,  1000.00),
            new WashStand("Hegaviken Wash", Color.RED, 20.00),
            new WashStand("Hemnes Wash", Color.WHITE,  50.00),
            new WashStand("Omneswick Wash", Color.GREEN, 300.00)));

    private static Set<FlooringTile> flooringTileSet = new HashSet<>(Arrays.asList(
            new FlooringTile("Canvas Tile", Color.BLACK ,Shape.DIAMOND,2.40),
            new FlooringTile("Carrara Tile", Color.GREEN,Shape.SQUARE,1.70),
            new FlooringTile("Festival Tile", Color.RED,Shape.HEXAGON,3.00),
            new FlooringTile("Valley Ridge Tile", Color.WHITE,Shape.TRIANGLE,3.90)));

    private static Set<Table> tablesSet = new HashSet<>(Arrays.asList(
            new Table("Zinus",68.99, Material.PINE,Shape.RECTANGLE),
            new Table("Effiel",89.99, Material.OAK,Shape.CIRCLE),
            new Table("Nathan",59.20, Material.CEDAR,Shape.SQUARE),
            new Table("Stanton",140.59, Material.BEECH,Shape.RECTANGLE)));

    private static Set<Bookcase> bookcasesSet = new HashSet<>(Arrays.asList(
            new Bookcase("Furinno", Color.WHITE,20.00, Material.BEECH),
            new Bookcase("TomCare", Color.BLACK,50.00, Material.CEDAR),
            new Bookcase("Sauder", Color.GRAY,150.0,Material.OAK),
            new Bookcase("Songmics", Color.GREEN,310.00, Material.PINE)));

    //Forms product set which consists of sets of different type products
    public static Set<Product> getProductSet(){
        Set<Product> productSet = new HashSet<>();
        productSet.addAll(washStandSet);
        productSet.addAll(flooringTileSet);
        productSet.addAll(tablesSet);
        productSet.addAll(bookcasesSet);
        return productSet;
    }

    //Forms product set only of products of requested type
    public static Set<Product> getProductSet(ProductType product){
        Set<Product> productSet = new HashSet<>();
        switch (product){
            case WASHSTAND:
                productSet.addAll(washStandSet);
                break;
            case TILE:
                productSet.addAll(flooringTileSet);
                break;
            case TABLE:
                productSet.addAll(tablesSet);
                break;
            case BOOKCASE:
                productSet.addAll(bookcasesSet);
                break;
            default:
                System.out.println("No such product type");
                productSet = Collections.emptySet();
        }
        return productSet;
    }

    //Prints collection
    public static <T> void printCollection(Collection<T> collection){
        if (collection.size() == 0){
            System.out.println("Nothing on the list");
        }
        for (T temp : collection){
            System.out.println(temp);
        }
    }


}
