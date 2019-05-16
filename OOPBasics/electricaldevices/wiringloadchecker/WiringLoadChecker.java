package growepam.electricaldevices.wiringloadchecker;

import java.util.Scanner;

public class WiringLoadChecker {

    private Scanner scan = new Scanner(System.in);
    private static double wiringMaxPowerLoad;
    private static double wiringLoad;

    public WiringLoadChecker(){}
    public WiringLoadChecker(double wiringMaxPowerLoad){
        WiringLoadChecker.wiringMaxPowerLoad = wiringMaxPowerLoad;
    }

    //reads and assigns wiringMaxPowerLoad value
    public void readMaxValue(){
        do{
            try{
                wiringMaxPowerLoad = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e){
                System.out.println("You have entered wrong load value! Please retry!!!");
                continue;
            }
            break;
        } while (true);

    }

    /*checks whether current wiringLoad value is greater than wiringMaxPoweLoad value
      and if so throws WiringOverloadException.
      If it is close to wiringMaxPoweLoad value prints warning message
    */
    public void checkWiringLoad() throws WiringOverloadException {
        if (wiringLoad >= wiringMaxPowerLoad){
            System.out.println("Wiring system is in flame");
            throw new WiringOverloadException();
        }else if ((wiringLoad + 150) > wiringMaxPowerLoad){
            System.out.println("Your wiring system is about to inflame! Reduce wiring load immediatly!\n");
        }
    }

    public void increaseWiringLoad(double powerValue){
        wiringLoad+=powerValue;
    }

    public void reduceWiringLoad(double powerValue){
        wiringLoad-=powerValue;
    }
    public double getWiringLoad() {
        return wiringLoad;
    }

    public double getwiringMaxPowerLoad() {
        return wiringMaxPowerLoad;
    }
}
