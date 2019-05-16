package growepam.hypermarket.products.sanitaryengineering;

import growepam.hypermarket.products.Product;
import growepam.hypermarket.engine.ProductManager;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.engine.Reader;
import growepam.hypermarket.tuningparameters.Color;
import growepam.hypermarket.tuningparameters.Shape;

import java.util.HashSet;
import java.util.Set;

public class FlooringTile extends Product {
    private Shape shape;
    private Color color;

    public FlooringTile(){}
    public FlooringTile(String nameOfFloooringTile, Color color,Shape shape, double flooringTilePrice){
        this.productType = ProductType.TILE;
        this.name = nameOfFloooringTile;
        this.price = flooringTilePrice;
        this.shape = shape;
        this.color = color;
    }
    
    public Set<Product> selector(){
        Set<Product> recommendations = ProductManager.getProductSet(ProductType.TILE);

        Color customColor;
        double customPrice;
        Shape customShape;

        System.out.println("Please enter parameters of select");
        System.out.println("Color (Press ENTER to ignore):");
        customColor = Reader.readColor();
        System.out.println("Price (Press ENTER to ignore):");
        customPrice = Math.abs(Reader.readDouble());
        System.out.println("Shape (Press ENTER to ignore):");
        customShape = Reader.readShape();

        for (Product product : new HashSet<>(recommendations)){
            FlooringTile tile = (FlooringTile)product;
            if ((customColor != null) && (!tile.getColor().equals(customColor))){
                recommendations.remove(tile);
                continue;
            }

            if ((customPrice != 0.0) && (tile.getPrice() > customPrice)){
                recommendations.remove(tile);
                continue;
            }

            if ((customShape != null) && (!tile.getShape().equals(customShape))){
                recommendations.remove(tile);
            }
        }
        return recommendations;
    }

    public Color getColor(){
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append("Naming: ").append(name);
        sb.append('\n').append("Product type: ").append(productType.toString().toLowerCase());
        sb.append('\n').append("Shape: ").append(shape.toString().toLowerCase());
        sb.append('\n').append("Color: ").append(color.toString().toLowerCase());
        sb.append('\n').append("Cost: ").append(price+"$").append(" / sqft");
        return sb.toString();
    }

}
