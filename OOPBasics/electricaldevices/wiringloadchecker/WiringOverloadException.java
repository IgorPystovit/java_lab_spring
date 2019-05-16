package growepam.electricaldevices.wiringloadchecker;

public class WiringOverloadException extends Exception {
    WiringOverloadException(){}
    WiringOverloadException(String msg){
        super(msg);
    }
}
