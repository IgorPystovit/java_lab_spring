package com.epam.igorpystovit.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Reader {
    private static Scanner scan = new Scanner(System.in);
    private ResourceBundle resourceBundle;
    private Logger logger = LogManager.getLogger(Reader.class.getName());

    public Reader(){
        resourceBundle = ResourceBundle.getBundle("enUS");
    }

    public Reader(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    public Reader(String language,String country){
        try{
            resourceBundle = ResourceBundle.getBundle(language+country);
        } catch (MissingResourceException e){
            logger.error("Wrong property file");
            resourceBundle = ResourceBundle.getBundle("enUS");
        } catch (Exception e){
            logger.error("Something went wrong");
        }
    }

    public String readString(){
        return scan.nextLine();
    }

    public List<String> endlessStringReader(){
        logger.info(resourceBundle.getString("Info.inputStringsPressEnterToStop"));
        List<String> strings = new LinkedList<>();
        String tempString = null;
        do{
            tempString = scan.nextLine();
            if (!tempString.equals("")){
                strings.add(tempString);
            }
        }while (!tempString.equals(""));
        return strings;
    }

    public int readInt(){
        int value = 0;
        do {
            try{
                value = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                logger.error(resourceBundle.getString("Exception.badInput"));
                continue;
            }
            break;
        } while (true);
        return value;
    }
}
