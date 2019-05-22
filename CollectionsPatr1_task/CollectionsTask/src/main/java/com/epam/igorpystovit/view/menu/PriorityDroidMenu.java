package com.epam.igorpystovit.view.menu;

import com.epam.igorpystovit.controller.Controller;
import com.epam.igorpystovit.model.shipwithdroids.Droid;

import java.util.LinkedList;
import java.util.List;

public class PriorityDroidMenu implements Menu{
    private Controller controller = new Controller();

    @Override
    public void show() {
        List<Droid> createdDroids = new LinkedList<>();
        do{
            System.out.println("Droid manager actions:\n" +
                    "-Create droid;\n" +
                    "-Put droid;\n" +
                    "-Remove droid from ship;\n" +
                    "-Print droids(that are on board);\n" +
                    "-Print my droids(created droids);\n" +
                    "-Exit;");
            String request = controller.scanRequest();
            switch (request){
                case "CREATE DROID":
                    createdDroids.add(controller.createDroid());
                    break;
                case "PUT DROID":
                    if (createdDroids.size() == 0){
                        System.out.println("No created droids");
                        logger.info("No created droids");
                    }else{
                        controller.putPriorityDroid(controller.getDroidByModel(createdDroids));
                    }
                    break;
                case "REMOVE DROID FROM SHIP":
                    Droid remvoedDroid = controller.removePriorityDroid();
                    System.out.println("Removed droid");
                    System.out.println(remvoedDroid);
                    break;
                case "PRINT DROIDS":
                    controller.printResult(controller::printPriorityDroids);
                    break;
                case "PRINT MY DROIDS":
                    controller.printResult(() -> createdDroids.stream().forEach(System.out::println));
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request");
                    logger.warn("Bad request");
            }
        }while (true);
    }
}
