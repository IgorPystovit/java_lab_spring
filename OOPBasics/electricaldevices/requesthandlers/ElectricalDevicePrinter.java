package growepam.electricaldevices.requesthandlers;

import growepam.electricaldevices.electricaldevice.ElectricalDevice;

import java.util.List;

public class ElectricalDevicePrinter implements RequestHandler {
    //Prints given list of electrical devices
    public void performRequest(List<ElectricalDevice> electricalDevices){
        System.out.println();
        if (electricalDevices.size() == 0){
            System.out.println("There is no electrical devices");
        }else{
            for (ElectricalDevice tempDevice : electricalDevices){
                System.out.println(tempDevice);
            }
        }
    }

}
