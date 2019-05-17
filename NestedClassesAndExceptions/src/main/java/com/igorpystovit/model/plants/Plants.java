package com.igorpystovit.model.plants;

import com.igorpystovit.controller.Controller;
import com.igorpystovit.model.Reader;
import com.igorpystovit.view.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Plants {
    private static final Controller CONTROLLER = new Controller();
    private static final Logger logger = LogManager.getLogger(Plants.class.getName());

    private Scanner scan = new Scanner(System.in);
    private Color color;
    private Type type;
    private List<Plants> plants = new LinkedList<>();

    public Plants(){}
    public Plants(Color color, Type type){
        this.color = color;
        this.type = type;
    }

    public Menu menu = new Menu(){
        @Override
        public void show(){
            do{
                System.out.println("Actions:\n" +
                        "- create plant;\n" +
                        "- print plants;\n" +
                        "- exit;");
                String request = scan.nextLine().toUpperCase();
                switch (request){
                    case "CREATE PLANT":
                        try {
                            plants.add(create());
                        } catch (TypeException e){
                            logger.error("Wrong type");
                            continue;
                        } catch (ColorException e){
                            logger.error("Wrong color");
                            continue;
                        }
                        break;
                    case "PRINT PLANTS":
                        plants.stream().forEach(System.out::println);
                        break;
                    case "EXIT":
                        return;
                    default:
                        logger.warn("Bad input");
                }
            }while (true);
        }

    };

    private static Plants create() throws ColorException,TypeException{
        System.out.println("Input type of plant");
        CONTROLLER.print(new Plants()::printTypes);
        Type type = Reader.typeValue();
        System.out.println("Input color of plant");
        CONTROLLER.print(new Plants()::printColors);
        Color color = Reader.colorValue();
        return new Plants(color,type);
    }

    private void printTypes(){
        System.out.println("Available plant types");
        for (Type temp : Type.values()){
            System.out.println("-"+temp.toString().toLowerCase()+";");
        }
    }

    private void printColors(){
        System.out.println("Available plant colors");
        for (Color temp : Color.values()){
            System.out.println("-"+temp.toString().toLowerCase()+";");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Flower:\n");
        sb.append(" Type:"+type.toString().toLowerCase()+'\n');
        sb.append(" Color:"+color.toString().toLowerCase()+'\n');
        return sb.toString();
    }
}
