package lambdasandstreams.view.menu;

import lambdasandstreams.controller.Controller;

import java.util.Scanner;

public class LambdaMenu extends Menu {
    private static Scanner scan = new Scanner(System.in);
    private Controller controller = new Controller();
    private int[] input = new int[3];

    @Override
    public void show() {
        readInput();
        do{
            System.out.println("Input action:\n" +
                    "- average;\n" +
                    "- max value;\n" +
                    "- exit;");
            String action = scan.nextLine().toUpperCase();
            switch(action){
                case "AVERAGE":
                    controller.printResult(this::printAverage);
                    break;
                case "MAX VALUE":
                    controller.printResult(this::printMax);
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such action please retry\n");
            }
        } while (true);

    }

    private void readInput(){
        System.out.println("Input 3 values");
        for(int i = 0; i < input.length; i++){
            System.out.print("Value "+i+" = ");
            input[i] = controller.readIntValue();
        }
    }

    private void printAverage(){
        System.out.println("Average = "+controller.getLambdaAverageValue(input[0],input[1],input[2]));
    }

    private void printMax(){
        System.out.println("Max value = "+controller.getLamdaMaxValue(input[0],input[1],input[2]));
    }
}
