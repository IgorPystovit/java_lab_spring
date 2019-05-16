package growepam.hypermarket.engine;

import growepam.hypermarket.tuningparameters.Color;
import growepam.hypermarket.tuningparameters.Material;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.tuningparameters.Shape;

import java.util.Scanner;

//This class implements methods for reading data in the safe way
//By using recovery system we making sure that user is not able to input data of wrong type
//All methods have common semantic but different return types and informational messages to print
public class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static double readDouble(){
        double doubleValue = 0.0;
        do{
            try{
                String tempString = scan.nextLine();
                if (tempString.equals("")){
                    return doubleValue;
                }
                doubleValue = Double.parseDouble(tempString);
            } catch (NumberFormatException e){
                System.out.println("Wrong value! Please retry!");
                continue;
            }
            break;
        } while (true);
        return doubleValue;
    }

    public static ProductType readProductType(){
        ProductType productType;
        System.out.println("Available types:");
        for (ProductType type : ProductType.values()){
            System.out.println("- "+type.toString().toLowerCase()+";");
        }
        do{
            try{
                String tempString = scan.nextLine().toUpperCase();
                if (tempString.equals("")){
                    return null;
                }
                productType = ProductType.valueOf(tempString);
            } catch (IllegalArgumentException e){
                System.out.println("You have entered wrong product type! Please retry!");
                continue;
            }
            break;
        } while (true);
        return productType;
    }

    public static Color readColor(){
        Color color;
        System.out.println("Available colors:");
        for (Color temp : Color.values()){
            System.out.println("- "+temp.toString().toLowerCase()+";");
        }
        do{
            try{
                String tempString = scan.nextLine().toUpperCase();
                if (tempString.equals("")){
                    return null;
                }
                color = Color.valueOf(tempString);
            } catch (IllegalArgumentException e){
                System.out.println("You have entered wrong color! Please retry!");
                continue;
            }
            break;
        } while (true);
        return color;
    }

    public static Shape readShape(){
        Shape shape;
        System.out.println("Available shapes:");
        for (Shape temp : Shape.values()){
            System.out.println("- "+temp.toString().toLowerCase()+";");
        }
        do{
            try{
                String tempString = scan.nextLine().toUpperCase();
                if (tempString.equals("")){
                    return null;
                }
                shape = Shape.valueOf(tempString);
            } catch (IllegalArgumentException e){
                System.out.println("You have entered wrong shape! Please retry!");
                continue;
            }
            break;
        } while (true);
        return shape;
    }

    public static Material readMaterial(){
        Material material;
        System.out.println("Available materials:");
        for (Material temp : Material.values()){
            System.out.println("- "+temp.toString().toLowerCase()+";");
        }
        do{
            try{
                String tempString = scan.nextLine().toUpperCase();
                if (tempString.equals("")){
                    return null;
                }
                material = Material.valueOf(tempString);
            } catch (IllegalArgumentException e){
                System.out.println("You have entered wrong material! Please retry!");
                continue;
            }
            break;
        } while (true);
        return material;
    }
}
