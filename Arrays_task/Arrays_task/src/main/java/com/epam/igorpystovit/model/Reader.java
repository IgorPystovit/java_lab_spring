package com.epam.igorpystovit.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Reader {
    private static Logger logger = LogManager.getLogger(Reader.class.getName());
    private static Scanner scan = new Scanner(System.in);

    public static int readIntValue(){
        int value = 0;
        do{
            try{
                String string = scan.nextLine();
                value = Integer.parseInt(string);
            }catch (NumberFormatException e){
                logger.warn("Bad int value input!");
                continue;
            }
            break;
        }while (true);
        return value;
    }

    public static Integer[] readIntArray(){
        List<Integer> userList = new LinkedList<>();
        String userInput = null;
        do{
            try{
                userInput = scan.nextLine();
                if (!userInput.equals("")){
                    userList.add(Integer.parseInt(userInput));
                }
            }catch (NumberFormatException e){
                logger.error("Bad input!");
            }
        }while (!userInput.equals(""));
        return userList.toArray(new Integer[0]);
    }
}
