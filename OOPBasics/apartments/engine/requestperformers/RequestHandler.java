package growepam.apartments.engine.requestperformers;

import growepam.apartments.realestate.RealEstate;

import java.util.List;

public interface RequestHandler {
    List<RealEstate> performRequest();
}
