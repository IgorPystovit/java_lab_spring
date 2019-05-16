package growepam.gemstones.component;

import growepam.gemstones.product.Reader;
import growepam.gemstones.gemstone.Gemstone;

import java.util.Scanner;

//This class represents component of product
//It consists of gemstone field and weight field, which represents weight of specified gemstone
//It also includes componentCreator method and overrided equals method
public class Component{
    private static Scanner scan = new Scanner(System.in);
    private Gemstone gemstone;
    private double weight;

    public Component(){}
    public Component(Gemstone gemstone, double weight){
        this.gemstone = gemstone;
        this.weight = weight;
    }

    public void setGemstone(Gemstone gemstone) {
        this.gemstone = gemstone;
    }

    public Gemstone getGemstone() {
        return gemstone;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addWeight(double weightValue){
        weight += weightValue;
    }

    public double getWeight() {
        return weight;
    }

    //Makes gemstone and weight fields filled and returns newly created object Component
     public static Component componentCreator(){
        System.out.println("Please enter a gemstone name and its weight!");
        Gemstone gemstone = Reader.gemstoneReader();
        double weight = Reader.weightReader();
        return new Component(gemstone,weight);
    }

    //Overrides equals method and make it consider two components as equal if only their gemstone attributes are the same
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if (!(o instanceof Component)){
            return false;
        }

        return gemstone.equals(((Component) o).gemstone);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(gemstone).append("\n");
        sb.append("Weight: ").append(weight).append(" (miligrams);\n");
        return sb.toString();
    }
}
