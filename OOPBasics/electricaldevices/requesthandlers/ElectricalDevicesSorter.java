package growepam.electricaldevices.requesthandlers;

import growepam.electricaldevices.electricaldevice.ElectricalDevice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*This class represents engine which sorts electrical devices by their
* power consumption in ascending order*/
public class ElectricalDevicesSorter implements RequestHandler {
    private ElectricalDevicePrinter electricalDevicePrinter = new ElectricalDevicePrinter();

    //Calls sort method and then prints it
    public void performRequest(List<ElectricalDevice> electricalDevices){
           electricalDevicePrinter.performRequest(sortByPowerConsumption(electricalDevices));
    }

    /*Represents sort process
     Sorts given in ascending order*/
    private List<ElectricalDevice> sortByPowerConsumption(List<ElectricalDevice> electricalDevicesList){
        Collections.sort(electricalDevicesList);
        return electricalDevicesList;
    }

}
