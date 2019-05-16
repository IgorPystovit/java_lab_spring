package growepam.electricaldevices.electricaldevice;

import growepam.electricaldevices.PowerState;

public class ElectricalDevice implements Comparable<ElectricalDevice>{
    //This class simply represents electrical device. Namely its states and behavior
    private PowerState powerState = PowerState.OFF;
    private double powerConsumption;
    private String deviceName;

    public ElectricalDevice(){}
    public ElectricalDevice(String deviceName, double powerConsumption){
        this.deviceName = deviceName;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public int compareTo(ElectricalDevice device){
        int compareNum = 0;

        if (this.powerConsumption < device.powerConsumption){
            compareNum = -1;
        } else if (this.powerConsumption > device.powerConsumption){
            compareNum = 1;
        }

        return compareNum;
    }

    public PowerState getPowerState(){
        return powerState;
    }

    public void turnOn(){
        powerState = PowerState.ON;
    }

    public void turnOff(){
        powerState = PowerState.OFF;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Device name: ").append(deviceName.toLowerCase()).append(" ;\n");
        sb.append("State: ");
        if (powerState == PowerState.ON){
            sb.append("On");
        }else{
            sb.append("Off");
        }
        sb.append(" ;\n");
        sb.append("Power consumption: ").append(powerConsumption).append(" ;\n");
        return sb.toString();
    }

}
