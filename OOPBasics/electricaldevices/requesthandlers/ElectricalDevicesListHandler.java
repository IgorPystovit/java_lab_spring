package growepam.electricaldevices.requesthandlers;

import growepam.electricaldevices.*;
import growepam.electricaldevices.electricaldevice.ElectricalDevice;
import growepam.electricaldevices.electricaldevice.ElectricalDevicesMenu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*This class performs different operations with list of electrical devices such as add,remove,get.*/
public class ElectricalDevicesListHandler implements RequestHandler {
    private Scanner scan = new Scanner(System.in);
    private ListModifierType modifierType;

    public ElectricalDevicesListHandler(){}
    public ElectricalDevicesListHandler(ListModifierType modifierType){
        this.modifierType = modifierType;
    }

    /*Calls add,remove or get method based on
    * user request*/
    @Override
    public void performRequest(List<ElectricalDevice> electricalDevices){
        switch (modifierType){
            case ADD:
                addToList(electricalDevices);
                break;
            case REMOVE:
                removeFromList(electricalDevices);
                break;
            case GET:
                new ElectricalDevicePrinter().performRequest(getFromList(electricalDevices));
                break;
            default:
                return;
        }
    }

    /*Performs add operation*/
    private void addToList(List<ElectricalDevice> electricalDevices){
        System.out.println("Please enter name of electrical device and its power consumption");
        String deviceName;

        //disable user to create device with void name.Im not sure if
        // here do-while-loop recovery system makes sense , but I do not know way in which I could done it better
        do{
            deviceName = nameReader();
            if (deviceName.equals("")){
                System.out.println("You have entered no name! Please retry!!!");
                continue;
            }
            break;
        }while (true);
        double powerConsumption = powerValueReader();
        //check if device with such name is already present on the list
        ElectricalDevice electricalDevice = ElectricalDevicesMenu.getDeviceByName(electricalDevices,deviceName);
        if (electricalDevice == null){
            //add if absent
            electricalDevices.add(new ElectricalDevice(deviceName,powerConsumption));
        }else{
            System.out.println("Electrical device with such name is already present in list");
            electricalDevice.setPowerConsumption(powerConsumption);
        }
    }

    /*Performs remove operation*/
    private void removeFromList(List<ElectricalDevice> electricalDevices){
        System.out.println("Please enter name of electrical device and its power consumption");
        //read device name
        String deviceName = nameReader();
        //if electrical device with such name does not present on the list , inform user about it with informational message
        //if not remove from the list
        ElectricalDevice electricalDevice = ElectricalDevicesMenu.getDeviceByName(electricalDevices,deviceName);
        if (electricalDevice == null){
            System.out.println("There is no such electrical device");
        }else{
            electricalDevices.remove(electricalDevice);
        }
    }

    /*Performs get operation*/
    private List<ElectricalDevice> getFromList(List<ElectricalDevice> electricalDevices){
        List<ElectricalDevice> customElectricalDevices = new LinkedList<>();
        String customDeviceName = "";
        double customPowerConsumption = 0.0;
        System.out.println("Please enter name of electrical device you are looking for (Press Enter to ignore)");
         customDeviceName = nameReader();
        //Since every electical device has its unique name there could be only one device with such name
        //So if electrical device name was ignored we will search devices by value of their power consumption
        if (customDeviceName.equals("")){
            System.out.println("Please enter power consumption of electrical device you are looking for");
            customPowerConsumption = powerValueReader();
        }

        boolean hasName = (!customDeviceName.equals(""));
        //if device name was entered - call getDeviceByName method
        //if not walk through the list searching electrical device which has power consuption value equal to requested power consumption value
        if (hasName){
            ElectricalDevice electricalDevice = ElectricalDevicesMenu.getDeviceByName(electricalDevices,customDeviceName);
            if (electricalDevice != null){
                customElectricalDevices.add(electricalDevice);
            }else{
                System.out.println("There is no electrical device with such name");
                customElectricalDevices = Collections.emptyList();
            }
        }else{
            for (ElectricalDevice tempDevice : electricalDevices){
                if (tempDevice.getPowerConsumption() == customPowerConsumption){
                    customElectricalDevices.add(tempDevice);
                }
            }
        }

        if (customElectricalDevices.size() == 0){
            System.out.println("There is no such electrical devices");
            customElectricalDevices.addAll(Collections.emptyList());
        }
        return customElectricalDevices;
    }


    private String nameReader(){
        String deviceName = null;
        System.out.println("Name of device: ");
        deviceName = scan.nextLine().toUpperCase();
        return deviceName;
    }

    /*Method which reads double value and uses recovery
    in purpose of disabling user from inputing incorrect values */
    private double powerValueReader(){
        double powerConsumption = 0.0;
        //do-while-loop purpose is recovery
        do{
            try{
                System.out.println("Power consuption: ");
                powerConsumption = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e){
                System.out.println("You have entered wrong value of power consumption! Please retry!");
                continue;
            }
            break;
        }while (true);

        return powerConsumption;
    }
}
