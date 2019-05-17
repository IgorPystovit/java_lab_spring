package com.igorpystovit.controller;

import com.igorpystovit.model.plants.Plants;
import com.igorpystovit.model.rectanglearea.NegativaNumberException;
import com.igorpystovit.model.rectanglearea.RectangleAreaCalculator;
import com.igorpystovit.view.Menu;
import com.igorpystovit.view.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private static final RectangleAreaCalculator RECTANGLE_AREA_CALCULATOR = new RectangleAreaCalculator();
    private static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());
    private static final Plants PLANTS = new Plants();

    public int getRectangleArea(){
        int area = 0;
        try{
            area = RECTANGLE_AREA_CALCULATOR.calculateArea();
        } catch (NegativaNumberException e){
            badInput();
        }
        return area;
    }

    public Menu getPlantsMenu(){
        return PLANTS.menu;
    }
    public void print(Printable printable){
        printable.print();
    }

    private void badInput(){
        System.out.println("Negative number was inputted");
        LOGGER.error("Negative number was inputted");
    }
}
