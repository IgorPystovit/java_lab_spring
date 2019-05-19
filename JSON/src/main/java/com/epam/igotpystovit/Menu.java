package com.epam.igotpystovit;

import com.epam.igotpystovit.json.JSONValidator;
import com.epam.igotpystovit.json.parser.GsonParser;
import com.epam.igotpystovit.json.parser.JacksonParser;
import com.epam.igotpystovit.json.parser.Parser;
import com.epam.igotpystovit.model.Gun;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Menu {
    private static Scanner scan = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(Menu.class.getName());
    private static final File jsonFile = new File("src/main/resources/jsons/guns.json");
    private static final File jsonSchema = new File("src/main/resources/jsons/gunsSchema.json");

    public static void printCollection(List<Gun> list){
        Collections.sort(list,new GunComparator());
        for (Gun gun : list){
            System.out.println(gun);
        }
    }

    public void menu(){
        Parser parser = null;
        System.out.println("Input json file path");
        String jsonFile = scan.nextLine();
        System.out.println("Input json file schema path");
        String jsonSchema = scan.nextLine();

        do{


            System.out.println("Choose parser:\n" +
                    "-Jackson;\n" +
                    "-Gson;\n" +
                    "-Exit;");
            String request = scan.nextLine().toUpperCase();
            switch(request){
                case "JACKSON":
                    parser = new JacksonParser();
                    break;
                case "GSON":
                    parser = new GsonParser();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request");
                    logger.warn("Bad request");
            }
            if (parser != null){
                printCollection(parser.parseObjects(new File(jsonFile),new File(jsonSchema)));
            }
        }while (true);
    }
    public static void main(String[] args) {
        new Menu().menu();
    }
}
