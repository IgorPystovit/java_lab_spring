package growepam;

import growepam.airline.airlineengine.AirlineMenu;
import growepam.apartments.engine.menu.ApartmentsMenu;
import growepam.electricaldevices.electricaldevice.ElectricalDevicesMenu;
import growepam.hypermarket.engine.HypermarketMenu;
import growepam.gemstones.GemstoneMenu;

import java.util.Scanner;

public class Executor {
    //invokes manager menu according to user request
    public void managers(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to management system!");

        do{
            System.out.println("Available management systems:\n" +
                    "- Hypermarket manager;\n" +
                    "- Gemstones manager;\n" +
                    "- Airline manager;\n" +
                    "- Apartments manager;\n" +
                    "- Electrical devices manager;\n");
            System.out.println("Type \"Exit\" to exit the manager service");
            System.out.println("Enter manager system name:");
            String managerName = scan.nextLine().toUpperCase();
            Menu managerMenu;
            switch (managerName){
                case "HYPERMARKET MANAGER":
                    managerMenu = new HypermarketMenu();
                    break;
                case "GEMSTONES MANAGER":
                    managerMenu = new GemstoneMenu();
                    break;
                case "AIRLINE MANAGER":
                    managerMenu = new AirlineMenu();
                    break;
                case "APARTMENTS MANAGER":
                    managerMenu = new ApartmentsMenu();
                    break;
                case "ELECTRICAL DEVICES MANAGER":
                    managerMenu = new ElectricalDevicesMenu();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such manager! Please retry!");
                    continue;
            }
            managerMenu.menu();
        }while (true);
    }

    public static void main(String[] args) {
        new Executor().managers();
    }
}
