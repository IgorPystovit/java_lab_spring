package growepam.hypermarket.products.woodenfurniture;

import growepam.hypermarket.engine.ProductManager;
import growepam.hypermarket.tuningparameters.ProductType;
import growepam.hypermarket.engine.Reader;
import growepam.hypermarket.products.Product;
import growepam.hypermarket.tuningparameters.Material;
import growepam.hypermarket.tuningparameters.Shape;

import java.util.HashSet;
import java.util.Set;

public class Table extends Product{
    private Shape shapeOfTable;
    private Material material;

    public Table(){}

    public Table(String tableName, double tablePrice, Material material, Shape shapeOfTable){
        this.productType = ProductType.TABLE;
        this.name = tableName;
        this.price = tablePrice;
        this.material = material;
        this.shapeOfTable = shapeOfTable;
    }

    public Set<Product> selector(){
        Set<Product> recommendations = ProductManager.getProductSet(ProductType.TABLE);

        System.out.println("Please enter parameters of select");
        System.out.println("Price (Press ENTER to ignore):");
        double customPrice = Reader.readDouble();
        System.out.println("Material (Press ENTER to ignore):");
        Material customMaterial = Reader.readMaterial();
        System.out.println("Shape (Press ENTER to ignore):");
        Shape customShape = Reader.readShape();

        for (Product tempProduct : new HashSet<>(recommendations)){
            Table tempTable = (Table) tempProduct;
            if ((customPrice != 0.0) && (tempTable.getPrice() > customPrice)){
                recommendations.remove(tempTable);
                continue;
            }

            if ((customMaterial != null) && (!tempTable.getMaterial().equals(customMaterial))){
                recommendations.remove(tempTable);
                continue;
            }

            if ((customShape != null) && (!tempTable.getShape().equals(customShape))){
                recommendations.remove(tempTable);
            }
        }
        return recommendations;
    }

    public Shape getShape() {
        return shapeOfTable;
    }

    public Material getMaterial() {
        return material;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append("Naming: ").append(name);
        sb.append('\n').append("Product type: ").append(productType.toString().toLowerCase());
        sb.append('\n').append("Shape of table: ").append(shapeOfTable.toString().toLowerCase()+";");
        sb.append('\n').append("Wood material: ").append(material.toString().toLowerCase()+";");
        sb.append('\n').append("Cost: ").append(price+"$;");
        return sb.toString();
    }
}
