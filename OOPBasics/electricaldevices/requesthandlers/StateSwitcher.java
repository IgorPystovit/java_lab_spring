package growepam.electricaldevices.requesthandlers;

import growepam.electricaldevices.*;
import growepam.electricaldevices.electricaldevice.ElectricalDevice;
import growepam.electricaldevices.electricaldevice.ElectricalDevicesMenu;
import growepam.electricaldevices.wiringloadchecker.WiringLoadChecker;
import growepam.electricaldevices.wiringloadchecker.WiringOverloadException;

import java.util.List;
import java.util.Scanner;

/*This class represents state switcher which turns device on
 * or turns it off based on user request*/
public class StateSwitcher implements RequestHandler {

    private static Scanner scan = new Scanner(System.in);
    public WiringLoadChecker loadChecker = new WiringLoadChecker();
    private PowerState powerState;

    public StateSwitcher(){}
    public StateSwitcher(PowerState powerState){
        this.powerState = powerState;
    }

    /*Determines which of devices user wants to turn on or off and calls appropriate
    * Also this method calls checkWiringLoad method and crashes program in case of cathcing WiringOverloadException */
    public void performRequest(List<ElectricalDevice> electricalDevices){
        System.out.println("Type name of electrical device below");
        String deviceName = scan.nextLine().toUpperCase();
        ElectricalDevice electricalDevice = ElectricalDevicesMenu.getDeviceByName(electricalDevices,deviceName);

        if (electricalDevice == null){
            System.out.println("There is no such electrical device");
            return;
        }

        switch (powerState){
            case ON:
                if (turnDeviceOn(electricalDevice)){
                    System.out.println("Turned on!");
                }
                break;
            case OFF:
                if (turnDeviceOff(electricalDevice)) {
                    System.out.println("Turne off!");
                }
                break;
            default:
                System.out.println("Error message");
                return;
        }
        System.out.println("Total wiring load: "+loadChecker.getWiringLoad());
        try{
            loadChecker.checkWiringLoad();
        } catch (WiringOverloadException e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    /*Checks whether given device is already on and if so prints informational message.
    Otherwise turns it on and increases wiring load accordingly*/
    private boolean turnDeviceOn(ElectricalDevice electricalDevice){
        boolean turnedOn = false;
        if (electricalDevice.getPowerState() == PowerState.ON){
                System.out.println("Device is already on");
        }else{
            turnedOn = true;
            electricalDevice.turnOn();
            loadChecker.increaseWiringLoad(electricalDevice.getPowerConsumption());
        }
        return turnedOn;
    }

    /*Checks whether given device is already off and if so prints informational message.
    Otherwise turns it off and reduces wiring load accordingly*/
    private boolean turnDeviceOff(ElectricalDevice electricalDevice){
        boolean turnedOff = false;
        if (electricalDevice.getPowerState() == PowerState.OFF){
                System.out.println("Device is already off");
        }else{
            turnedOff = true;
            electricalDevice.turnOff();
            loadChecker.reduceWiringLoad(electricalDevice.getPowerConsumption());
        }
        return turnedOff;
    }
}
