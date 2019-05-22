package com.epam.igorpystovit.model;

import com.epam.igorpystovit.model.shipwithdroids.DroidType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Reader {
    private static Logger logger = LogManager.getLogger(Reader.class.getName());
    private static Scanner scan = new Scanner(System.in);

    public static double doubleValue(){
        double value = 0.0;
        do{
            try{
                value = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e){
                badInput("Bad double input");
                continue;
            }
            break;
        }while (true);

        return value;
    }

    public static DroidType droidTypeValue(){
        DroidType value;
        do{
            try{
                value = DroidType.valueOf(scan.nextLine().toUpperCase());
            } catch (IllegalArgumentException e){
                badInput("Bad droid type input");
                continue;
            }
            break;
        }while (true);
        return value;
    }

    public static void badInput(String msg){
        System.out.println("Bad input");
        logger.warn(msg);
    }
}
