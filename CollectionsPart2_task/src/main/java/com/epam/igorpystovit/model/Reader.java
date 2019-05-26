package com.epam.igorpystovit.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Reader {
    private static Scanner scan = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(Reader.class.getName());

    public static String readString(){
        return scan.nextLine();
    }

    public static Integer readInt(){
        String userNum = null;
        Integer intValue = 0;
        do{
            try{
                userNum = readString();
                intValue = Integer.parseInt(userNum);
            } catch (NumberFormatException e){
                logger.error("Bad input");
                continue;
            }
            break;
        }while (true);
        return intValue;
    }

    public static Double readDouble(){
        String userNum = null;
        Double doubleValue = 0.0;
        do{
            try {
                userNum = readString();
                doubleValue = Double.parseDouble(userNum);
            } catch (NumberFormatException e){
                logger.error("Bad input");
                continue;
            }
            break;
        }while (true);
        return doubleValue;
    }
}
