package growepam.hypermarket.products;

import growepam.hypermarket.tuningparameters.ProductType;

import java.util.Set;

//This class consists only of product attributes and abstract method selector
//By implementing selector each class that extends Product class defines alghorithm according to which
//recommendation list must be formed
public abstract class Product {
    protected String name;
    protected double price;
    protected ProductType productType;

    public abstract Set<Product> selector();

    public ProductType getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
