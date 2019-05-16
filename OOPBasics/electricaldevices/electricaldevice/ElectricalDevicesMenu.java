package growepam.electricaldevices.electricaldevice;

import growepam.Menu;
import growepam.electricaldevices.ListModifierType;
import growepam.electricaldevices.PowerState;
import growepam.electricaldevices.wiringloadchecker.WiringLoadChecker;
import growepam.electricaldevices.requesthandlers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricalDevicesMenu implements Menu{

    private List<ElectricalDevice> electricalDevices = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private WiringLoadChecker loadChecker = new WiringLoadChecker();

    @Override
    public void menu(){
        System.out.println("Welcome to electrical devices management system");
        System.out.println("Please enter maximum value of power which your wiring can take simultaneously");
        loadChecker.readMaxValue();
        do{
            System.out.println("Available actions:\n" +
                    "- add (to add device to list);\n" +
                    "- remove (to remove device from list);\n" +
                    "- get (to get device from lsit);\n" +
                    "- turn on (to turn on a device);\n" +
                    "- turn off (to turn off a device);\n" +
                    "- sort (to sort list of devices by power consumption in ascending order);\n" +
                    "- display (to display list of electrical devices);");
            System.out.println("\nPlease type your request");
            String requestListener = scan.nextLine().toUpperCase();
            RequestHandler requestHandler = null;
            switch (requestListener){
                case "ADD":
                    requestHandler = new ElectricalDevicesListHandler(ListModifierType.ADD);
                    break;
                case "REMOVE":
                    requestHandler = new ElectricalDevicesListHandler(ListModifierType.REMOVE);
                    break;
                case "GET":
                    requestHandler = new ElectricalDevicesListHandler(ListModifierType.GET);
                    break;
                case "DISPLAY":
                    requestHandler = new ElectricalDevicePrinter();
                    break;
                case "TURN ON":
                    requestHandler = new StateSwitcher(PowerState.ON);
                    break;
                case "TURN OFF":
                    requestHandler = new StateSwitcher(PowerState.OFF);
                    break;
                case "SORT":
                    requestHandler = new ElectricalDevicesSorter();
                    break;
                case "EXIT":
                    return;
                default:
                    System.out.println("No such request! Please retry!");
                    continue;
            }
            process(electricalDevices,requestHandler);
        }while (true);

    }

    //strategy-like method
    private void process(List<ElectricalDevice> electricalDevices, RequestHandler requestHandler){
        requestHandler.performRequest(electricalDevices);
    }

    //returns electrical device from list of electrical devices by electrical device name specified as deviceName
    //if electrical device with such name is not present on the list returns null
    public static ElectricalDevice getDeviceByName(List<ElectricalDevice> electricalDevices, String deviceName){
        ElectricalDevice electricalDevice = null;
        for (ElectricalDevice tempDevice : electricalDevices){
            if (tempDevice.getDeviceName().equals(deviceName)){
                electricalDevice = tempDevice;
                break;
            }
        }
        return electricalDevice;
    }

    //returns list of electrical devices
    public List<ElectricalDevice> getElectricalDevices(){
        return electricalDevices;
    }
}
