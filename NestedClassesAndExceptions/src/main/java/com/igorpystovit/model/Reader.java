package com.igorpystovit.model;

import com.igorpystovit.model.plants.Color;
import com.igorpystovit.model.plants.ColorException;
import com.igorpystovit.model.plants.Type;
import com.igorpystovit.model.plants.TypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Reader {
    private static Scanner scan = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(Reader.class.getName());
    private Reader(){}


    public static int intValue(){
        int value = 0;
        do{
           try{
               value = Integer.parseInt(scan.nextLine());
           }catch (NumberFormatException e){
               badInput();
               continue;
           }
           break;
        } while(true);
        return value;
    }

    public static Color colorValue() throws ColorException{
        Color value;
        try {
            value = Color.valueOf(scan.nextLine().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new ColorException();
        }
        return value;
    }

    public static Type typeValue() throws TypeException{
        Type value;
        try {
            value = Type.valueOf(scan.nextLine().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new TypeException();
        }
        return value;
    }

    private static void badInput(){
        System.out.println("bad input! Please retry");
        logger.error("Bad Input");
    }

    private static void badInput(String msg){
        System.out.println("bad input! Please retry");
        logger.error(msg);
    }
}
