package growepam.apartments.engine.requestperformers.listmaker;

import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.realestate.RealEstate;
import growepam.apartments.estatemanagers.RealEstateManager;
import growepam.apartments.engine.requestperformers.RequestHandler;

import java.util.LinkedList;
import java.util.List;

//This class represents recomendation list maker
public class RecommendationListMaker implements RequestHandler {
    private Parameters parameters = new Parameters();
    private RealEstateManager realEstateManager = new RealEstateManager();

    //invokes parameter reader method
    //and infokes recommendation list maker method
    public List<RealEstate> performRequest(){
        parameters.read();
        List<RealEstate> recommendationList = formRecommendations();
        return recommendationList;
    }

    //forms recommendation list based on given parameters
    private List<RealEstate> formRecommendations(){
        List<RealEstate> estateList = new LinkedList<>(realEstateManager.getEstateList(parameters.getCustomEstateType()));
        //check which of parameters were entered
        boolean hasArea = (parameters.getCustomArea() != 0.0);
        boolean hasPrice = (parameters.getCustomPrice() != 0.0);
        boolean hasInfrastructureList = (parameters.getCustomInfrastructureObjectList().size() != 0);

        //walk through list in order of deleting objects that does not suit the parameters
        for (RealEstate tempEstate : new LinkedList<>(estateList)){
            if (hasArea){
                if (tempEstate.getArea() > parameters.getCustomArea()){
                    estateList.remove(tempEstate);
                    continue;
                }
            }

            if (hasPrice){
                if (tempEstate.getPrice() > parameters.getCustomPrice()){
                    estateList.remove(tempEstate);
                    continue;
                }
            }

            if (hasInfrastructureList){
                boolean hasInfrastractureObject = false;
                for (InfrastructureObject tempCustomInfrastructureObject : parameters.getCustomInfrastructureObjectList()){
                    double distanceToOject = tempEstate.getDistanceToObject(tempCustomInfrastructureObject.getInfrastructureObjectType());
                    if ((distanceToOject != 0.0) && (distanceToOject <= tempCustomInfrastructureObject.getDistance())){
                        hasInfrastractureObject = true;
                    }
                }
                if (!hasInfrastractureObject){
                    estateList.remove(tempEstate);
                }
            }
        }
        return estateList;
    }

}
