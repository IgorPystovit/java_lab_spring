package growepam.apartments.estatemanagers;

import growepam.apartments.realestatetypes.EstateType;
import growepam.apartments.realestate.RealEstate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//This class represent real estate manager
public class RealEstateManager {
    private FlatEstateManager flatManager= new FlatEstateManager();
    private MansionEstateManager mansionManager = new MansionEstateManager();
    private PenthouseEstateManager penthouseManager = new PenthouseEstateManager();

    //Returns list of estates of specified type
    public List<RealEstate> getEstateList(EstateType estateType){
        List<RealEstate> estateList = null;
        switch (estateType){
            case FLAT:
                estateList = new LinkedList<>(flatManager.flatEstateList);
                break;
            case MANSION:
                estateList = new LinkedList<>(mansionManager.mansionEstateList);
                break;
            case PENTHOUSE:
                estateList = new LinkedList<>(penthouseManager.penthouseEstateList);
                break;
            default:
                estateList = new LinkedList<>(Collections.emptyList());
                break;
        }
        return estateList;
    }

    //Returns list of estates of all types
    public List<RealEstate> getEstateList(){
        List<RealEstate> realEstateList = new LinkedList<>();
        realEstateList.addAll(flatManager.flatEstateList);
        realEstateList.addAll(mansionManager.mansionEstateList);
        realEstateList.addAll(penthouseManager.penthouseEstateList);
        return realEstateList;
    }



}
