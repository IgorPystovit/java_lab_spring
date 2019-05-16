package growepam.apartments.estatemanagers;

import growepam.apartments.realestate.Address;
import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.infrastructure.InfrastructureObjectType;
import growepam.apartments.realestatetypes.Penthouse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PenthouseEstateManager {
    public List<Penthouse> penthouseEstateList = new LinkedList<>(Arrays.asList((
            new Penthouse.PenthouseBuilder("900000", 1100.8)
                    .address(new Address("Ukraine","Lviv","Horodotska St.",179))
                    .bedrooms(4)
                    .floorNum(10)
                    .hasTerrace(true)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,700),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,500))
                    .build()),
            new Penthouse.PenthouseBuilder("760000",930)
                    .address(new Address("Ukraine","Lviv","Bibliotechna St.",9))
                    .bedrooms(3)
                    .floorNum(9)
                    .hasTerrace(false)
                    .infrastructure(new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,400))
                    .build(),
            new Penthouse.PenthouseBuilder("500000",793.2)
                    .address(new Address("Ukraine","Lviv","Bazarna St.",43))
                    .bedrooms(7)
                    .floorNum(12)
                    .hasTerrace(true)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.SCHOOL,877),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,530),
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,390))
                    .build(),
            new Penthouse.PenthouseBuilder("360000",678.6)
                    .address(new Address("Ukraine","Lviv","Botkina St.",12))
                    .bedrooms(4)
                    .floorNum(6)
                    .hasTerrace(true)
                    .infrastructure
                            (new InfrastructureObject(InfrastructureObjectType.CINEMA,600),
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,200))
                    .build(),
            new Penthouse.PenthouseBuilder("100000",550)
                    .address(new Address("Uktaine","Lviv","Ivana Honty St.",90))
                    .bedrooms(5)
                    .floorNum(8)
                    .hasTerrace(true)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,150),
                            new InfrastructureObject(InfrastructureObjectType.CINEMA,200),
                            new InfrastructureObject(InfrastructureObjectType.KINDERGARTEN,400))
                    .build(),
            new Penthouse.PenthouseBuilder("300000",660)
                    .address(new Address("Ukraine","Lviv","Grusheva St.",25))
                    .bedrooms(5)
                    .floorNum(12)
                    .hasTerrace(false)
                    .infrastructure(
                            new InfrastructureObject(InfrastructureObjectType.THEATRE,300),
                            new InfrastructureObject(InfrastructureObjectType.HYPERMARKET,500))
                    .build()));

}
