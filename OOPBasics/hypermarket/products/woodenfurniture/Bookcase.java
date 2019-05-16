package growepam.hypermarket.products.woodenfurniture;

import growepam.hypermarket.engine.ProductManager;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.engine.Reader;
import growepam.hypermarket.products.Product;
import growepam.hypermarket.tuningparameters.Color;
import growepam.hypermarket.tuningparameters.Material;

import java.util.HashSet;
import java.util.Set;

public class Bookcase extends Product {
    private Material material;
    private Color color;

    public Bookcase(){}
    public Bookcase(String BookcaseName, Color color, Double bookcasePrice, Material material){
        this.productType = ProductType.BOOKCASE;
        this.name = BookcaseName;
        this.price = bookcasePrice;
        this.color = color;
        this.material = material;
    }

    public Set<Product> selector(){
        Set<Product> recommendations = ProductManager.getProductSet(ProductType.BOOKCASE);

        System.out.println("Please enter parameters of select");
        System.out.println("Price (Press ENTER to ignore):");
        double customPrice = Reader.readDouble();
        System.out.println("Material (Press ENTER to ignore):");
        Material customMaterial = Reader.readMaterial();
        System.out.println("Color (Press ENTER to ignore):");
        Color customColor = Reader.readColor();

        for (Product tempProduct : new HashSet<>(recommendations)){
            Bookcase tempBookcase = (Bookcase) tempProduct;
            if ((customPrice != 0.0) && (tempBookcase.getPrice() > customPrice)){
                recommendations.remove(tempBookcase);
                continue;
            }

            if ((customMaterial != null) && (!tempBookcase.getMaterial().equals(customMaterial))){
                recommendations.remove(tempBookcase);
                continue;
            }

            if ((customColor != null) && (!tempBookcase.getColor().equals(customColor))){
                recommendations.remove(tempBookcase);
            }

        }
        return recommendations;
    }

    public Color getColor() {
        return color;
    }

    public Material getMaterial(){
        return material;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append("Naming: ").append(name);
        sb.append('\n').append("Product type: ").append(productType.toString().toLowerCase());
        sb.append('\n').append("Wood material: ").append(material.toString().toLowerCase()+";");
        sb.append('\n').append("Color: ").append(color.toString().toLowerCase()).append(";");
        sb.append('\n').append("Cost: ").append(price+"$;");
        return sb.toString();
    }

}