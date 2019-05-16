package growepam.apartments.apartmentexceptions;

public class NoPriceException extends Exception {
    public NoPriceException(){}
    public NoPriceException(String msg){
        super(msg);
    }
}
