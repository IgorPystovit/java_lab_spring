package growepam.electricaldevices.requesthandlers;

import growepam.electricaldevices.electricaldevice.ElectricalDevice;

import java.util.List;

public interface RequestHandler {
    void performRequest(List<ElectricalDevice> electricalDevices);
}
