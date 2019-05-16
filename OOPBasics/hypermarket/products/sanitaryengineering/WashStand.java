package growepam.hypermarket.products.sanitaryengineering;

import growepam.hypermarket.products.Product;
import growepam.hypermarket.engine.ProductManager;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.engine.Reader;
import growepam.hypermarket.tuningparameters.Color;

import java.util.HashSet;
import java.util.Set;

public class WashStand extends Product { ;
    private Color color;

    public WashStand() {}
    public WashStand(String nameOfWashStand, Color color, double washstandPrice) {
        this.productType = ProductType.WASHSTAND;
        this.name = nameOfWashStand;
        this.color = color;
        this.price = washstandPrice;
    }


    @Override
    public Set<Product> selector(){
        Set<Product> recommendations = ProductManager.getProductSet(ProductType.WASHSTAND);
        System.out.println("Please enter parameters of select");
        System.out.println("Price (Press ENTER to ignore):");
        double customPrice = Math.abs(Reader.readDouble());
        System.out.println("Color (Press ENTER to ignore):");
        Color customColor = Reader.readColor();
        for (Product product : new HashSet<>(recommendations)){
            WashStand washStand = (WashStand)product;
            if ((customPrice != 0.0) && (washStand.getPrice() > customPrice)){
                recommendations.remove(washStand);
                continue;
            }

            if ((customColor != null) && (!washStand.getColor().equals(customColor))){
                recommendations.remove(washStand);
            }
        }
        return recommendations;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append("Naming: ").append(name);
        sb.append('\n').append("Product type: ").append(productType.toString().toLowerCase());
        sb.append('\n').append("Color: ").append(color.toString().toLowerCase()+";");
        sb.append('\n').append("Price: ").append(price + "$;");
        return sb.toString();
    }
}
