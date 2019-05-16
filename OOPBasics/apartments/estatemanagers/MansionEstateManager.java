package growepam.apartments.estatemanagers;

import growepam.apartments.realestate.Address;
import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.infrastructure.InfrastructureObjectType;
import growepam.apartments.realestatetypes.Mansion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MansionEstateManager {
    public List<Mansion> mansionEstateList = new LinkedList<>(Arrays.asList(
            new Mansion.MansionBuilder("4000000",2400)
                    .address(new Address("Ukraine","Lviv","Washington St.",93))
                    .bathroomsNum(4)
                    .bedroomsNum(8)
                    .numberOfFloors(3)
                    .infrustructure(
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,750),
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,600),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,100))
                    .build(),
            new Mansion.MansionBuilder("3900000",2145.9)
                    .address(new Address("Ukraine","Lviv","Hetmana Mazepy St.",29))
                    .bathroomsNum(4)
                    .bedroomsNum(3)
                    .numberOfFloors(2)
                    .infrustructure()
                    .build(),
            new Mansion.MansionBuilder("2500000",1789.2)
                    .address(new Address("Ukraine","Lviv","Chornovola St.",25))
                    .bathroomsNum(4)
                    .bedroomsNum(8)
                    .numberOfFloors(3)
                    .infrustructure(
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,500),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,200),
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,500))
                    .build(),
            new Mansion.MansionBuilder("3000000",1930.5)
                    .address(new Address("Ukraine","Lviv","Green St.",43))
                    .bathroomsNum(2)
                    .bedroomsNum(4)
                    .numberOfFloors(1)
                    .infrustructure(
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,500))
                    .build(),
            new Mansion.MansionBuilder("1500000",1345)
                    .address(new Address("Ukraine","Lviv","Karpinskoho St.",43))
                    .bathroomsNum(2)
                    .bedroomsNum(5)
                    .numberOfFloors(2)
                    .infrustructure(
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,400),
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,600),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,750))
                    .build(),
            new Mansion.MansionBuilder("2000000",1670)
                    .address(new Address("Ukraine","Lviv","Brullov St.",30))
                    .bathroomsNum(3)
                    .bedroomsNum(8)
                    .numberOfFloors(4)
                    .infrustructure(
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,600),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,450),
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,350))
                    .build()));
}
