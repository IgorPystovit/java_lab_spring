package com.igorpystovit.model.rectanglearea;

import com.igorpystovit.model.*;
import java.util.Scanner;

public class RectangleAreaCalculator {
    private static Scanner scan = new Scanner(System.in);

    public int calculateArea() throws NegativaNumberException {
        int[] sides = readSideValues();
        return squareRectangle(sides[0],sides[1]);
    }

    private int squareRectangle(int a, int b) throws NegativaNumberException{
        if((a < 0) || (b < 0)){
            throw new NegativaNumberException();
        }
        return a*b;
    }

    private int[] readSideValues(){
        int[] sides = new int[2];
        System.out.println("Input side A");
        sides[0] = Reader.intValue();
        System.out.println("input side B");
        sides[1] = Reader.intValue();
        return sides;
    }
}
