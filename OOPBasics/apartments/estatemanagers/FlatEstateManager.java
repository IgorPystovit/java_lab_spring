package growepam.apartments.estatemanagers;

import growepam.apartments.realestate.Address;
import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.infrastructure.InfrastructureObjectType;
import growepam.apartments.realestatetypes.Flat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FlatEstateManager {
    public List<Flat> flatEstateList = new LinkedList<>(Arrays.asList(
            new Flat.FlatBuilder("1900",830.2)
                    .address(new Address("Ukraine", "Lviv", "Hetmana Mazepy", 5))
                    .bedrooms(4)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,900))
                    .build(),
            new Flat.FlatBuilder("290",150)
                    .address(new Address("Ukraine", "London", "Volynska St.", 25))
                    .bedrooms(2)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,300),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,250))
                    .build(),
            new Flat.FlatBuilder("500",450)
                    .address(new Address("Ukraine","Lviv","Chornovola St.",35))
                    .bedrooms(4)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,500),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,600))
                    .build(),
            new Flat.FlatBuilder("590",600)
                    .address(new Address("Ukraine","Lviv","Brullov St",8))
                    .bedrooms(3)
                    .infrastructure()
                    .build(),
            new Flat.FlatBuilder("700",250)
                    .address(new Address("Ukraine","Lviv","Ivana Honty St.",45))
                    .bedrooms(4)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,600),
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,400),
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,200))
                    .build(),
            new Flat.FlatBuilder("400",278)
                    .address(new Address("Ukraine","Lviv","Grusheva St.",21))
                    .bedrooms(2)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,100),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,300),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,500))
                    .build()));

}
