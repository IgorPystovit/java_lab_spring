package growepam.apartments.realestate;

import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.infrastructure.InfrastructureObjectType;
import growepam.apartments.realestatetypes.EstateType;

import java.util.List;

//This class represents real estate object
//It consists of area, price and estate type attributes
//It also includes infrustructure object list of objects which are nearby the property
public class RealEstate {
    protected double area;
    protected String price;
    protected EstateType estateType;
    protected List<InfrastructureObject> infrastructureObjectList;
    protected Address address;

    public List<InfrastructureObject> getInfrastructureObjectList() {
        return infrastructureObjectList;
    }

    public double getPrice(){
        return Double.parseDouble(price);
    }

    public double getArea() {
        return area;
    }

    public double getDistanceToObject(InfrastructureObjectType objectType){
        for (InfrastructureObject iTempObject : infrastructureObjectList){
            if (iTempObject.getInfrastructureObjectType().equals(objectType)){
                return iTempObject.getDistance();
            }
        }
        return 0.0;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    protected String firstCharToUpperCase(String string){
        string = string.toUpperCase();
        string = string.charAt(0) + string.substring(1).toLowerCase();
        return string;
    }
}
