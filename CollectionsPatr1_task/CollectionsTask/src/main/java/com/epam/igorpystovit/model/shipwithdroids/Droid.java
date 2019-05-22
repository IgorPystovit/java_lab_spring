package com.epam.igorpystovit.model.shipwithdroids;

import com.epam.igorpystovit.controller.Controller;
import com.epam.igorpystovit.model.Reader;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class Droid {
    private static Scanner scan = new Scanner(System.in);
    private static Controller controller = new Controller();

    private String model;
    private double height;
    private DroidType type;
    private double strength;

    public Droid(){}
    public Droid(DroidType type,String model , double height, double strength){
        this.type = type;
        this.height = height;
        this.strength = strength;
        this.model = model;
    }

    public static Droid create(){
        System.out.println("Input droid model");
        String model = scan.nextLine();
        System.out.println("Input droid type");
        controller.printResult(controller::printDroidTypes);
        DroidType type = Reader.droidTypeValue();
        System.out.println("Input droid height(meters)");
        double height = Reader.doubleValue();
        System.out.println("Input droid strength");
        double strength = Reader.doubleValue();
        return new Droid(type,model,height,strength);
    }

    public double getHeight() {
        return height;
    }

    public double getStrength() {
        return strength;
    }

    public DroidType getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Droid model: "+model+"{\n");
        sb.append(" Type:"+type.toString().toLowerCase()+";\n");
        sb.append(" Height(meters):"+height+";\n");
        sb.append(" Strength:"+strength+";\n");
        sb.append("}");
        return sb.toString();
    }
}
