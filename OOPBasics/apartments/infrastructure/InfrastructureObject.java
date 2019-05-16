package growepam.apartments.infrastructure;

//This class represents Infrustructure object which consists of infrustucture object type and distance to this object attributes
public class InfrastructureObject {
    private double distance;
    private InfrastructureObjectType infrastructureObjectType;

    public InfrastructureObject(){}
    public InfrastructureObject(InfrastructureObjectType infrastructureObjectType, double distance) {
        this.infrastructureObjectType = infrastructureObjectType;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public InfrastructureObjectType getInfrastructureObjectType() {
        return infrastructureObjectType;
    }

    public void setInfrastructureObjectType(InfrastructureObjectType infrastructureObjectType) {
        this.infrastructureObjectType = infrastructureObjectType;
    }
}
