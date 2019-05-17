package com.igorpystovit.view;

import com.igorpystovit.controller.Controller;
import com.igorpystovit.model.AutoCloseableRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private Controller controller = new Controller();
    private Logger logger = LogManager.getLogger(Menu.class.getName());
    private Scanner scan = new Scanner(System.in);

    public void show(){
        do{
            System.out.println("Available actions:\n" +
                    "- Rectangle area;\n" +
                    "- Plants;\n" +
                    "- Invoke autocloseable;\n" +
                    "- Exit");
            String request = scan.nextLine().toUpperCase();
            switch (request){
                case "RECTANGLE AREA":
                    System.out.println("Rectangle area = "+controller.getRectangleArea());
                    break;
                case "PLANTS":
                    controller.getPlantsMenu().show();
                    break;
                case "INVOKE AUTOCLOSEABLE":
                    AutoCloseableRes.test();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request");
                    logger.warn("Bad request");
            }
        }while (true);
    }


    public static void main(String[] args) {
        new Menu().show();
    }
}
