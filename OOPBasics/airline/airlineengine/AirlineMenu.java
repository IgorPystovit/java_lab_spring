package growepam.airline.airlineengine;

import growepam.Menu;
import growepam.airline.Airline;

import java.util.Scanner;

//This class represents menu
public class AirlineMenu implements Menu {
    private static Scanner scan = new Scanner(System.in);
    private static AirlineEvaluator airlineEvaluator = new AirlineEvaluator();

    //Invokes method according to user request
    @Override
    public void menu(){
        Airline airline = null;
        System.out.println("Welcome to airline creator manager!");
        System.out.println("Type you request below:");
        do{
            System.out.println("List of requests;\n" +
                    "- Create airline (to create airline);\n" +
                    "- Print airline (to print name of airline and its aircraft;\n" +
                    "- Evaluate (to invoke airline evaluator);\n" +
                    "- Exit (to exit program);\n");
            System.out.println("Type your request:");
            String request = scan.nextLine().toUpperCase();
            switch (request){
                case "CREATE AIRLINE":
                    if (airline != null){
                        System.out.println("Your previous airline will be deleted. Continue?");
                        if (scan.nextLine().toUpperCase().equals("YES")){
                            airline = Airline.create();
                            continue;
                        }else{
                            continue;
                        }
                    }
                    airline = Airline.create();
                    break;
                case "PRINT AIRLINE":
                    if (airline != null){
                        System.out.println(airline);
                    }else{
                        System.out.println("Create airline first!\n");
                    }
                    break;
                case "EVALUATE":
                    if (airline != null){
                        airlineEvaluator.evaluator(airline);
                    }else{
                        System.out.println("Create airline first!\n");
                    }
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request\n");
            }
        }while (true);
    }
}
