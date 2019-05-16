package growepam.apartments.realestatetypes;

import growepam.apartments.realestate.Address;
import growepam.apartments.apartmentexceptions.NoApartmentAreaException;
import growepam.apartments.apartmentexceptions.NoPriceException;
import growepam.apartments.apartmentexceptions.NoRoomsNumException;
import growepam.apartments.infrastructure.InfrastructureObject;
import growepam.apartments.realestate.RealEstate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Penthouse extends RealEstate {
    private int floorNum;
    private boolean hasTerrace;
    private int bedroomsNum;

    public Penthouse(){}
    public Penthouse(PenthouseBuilder penthouseBuilder){
        estateType = EstateType.PENTHOUSE;
        this.area = penthouseBuilder.area;
        this.bedroomsNum = penthouseBuilder.bedroomsNum;
        this.floorNum = penthouseBuilder.floorNum;
        this.hasTerrace = penthouseBuilder.hasTerrace;
        this.price = penthouseBuilder.price;
        this.infrastructureObjectList = penthouseBuilder.infrastructureObjectList;
        this.address = penthouseBuilder.address;
    }

    //Builder design pattern
    public static class PenthouseBuilder{
        private double area;
        private int bedroomsNum;
        private int floorNum;
        private boolean hasTerrace;
        private String price;
        private List<InfrastructureObject> infrastructureObjectList = new LinkedList<>();
        private Address address;

        public PenthouseBuilder(){}
        public PenthouseBuilder(String price, double area){
            this.price = price;
            this.area = area;
        }

        public PenthouseBuilder floorNum(int floorNum){
            this.floorNum = floorNum;
            return this;
        }

        public PenthouseBuilder hasTerrace(boolean hasTerrace){
            this.hasTerrace = hasTerrace;
            return this;
        }

        public PenthouseBuilder address(Address address){
            this.address = address;
            return  this;
        }

        public PenthouseBuilder bedrooms(int bedroomsNum){
            this.bedroomsNum = bedroomsNum;
            return this;
        }

        public PenthouseBuilder infrastructure(InfrastructureObject... infrastructure){
            infrastructureObjectList.addAll(Arrays.asList(infrastructure));
            return this;
        }

        public Penthouse build(){
            Penthouse Penthouse = new Penthouse(this);
            try{
                validatePenthouse(Penthouse);
            } catch (NoRoomsNumException e){
                e.printStackTrace();
            } catch (NoPriceException e){
                e.printStackTrace();
            } catch (NoApartmentAreaException e){
                e.printStackTrace();
            }

            return Penthouse;
        }

        private void validatePenthouse(Penthouse penthouse) throws NoApartmentAreaException,NoPriceException,NoRoomsNumException{
            if (penthouse.bedroomsNum <= 0){
                throw new NoRoomsNumException();
            }

            if (penthouse.area <= 0){
                throw new NoApartmentAreaException();
            }

            if (Integer.parseInt(penthouse.price) <= 0){
                throw new NoPriceException();
            }
        }
    }

    public int getBedroomsNum() {
        return bedroomsNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public boolean isHasTerrace() {
        return hasTerrace;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(firstCharToUpperCase(getEstateType().toString())).append("\n\n");
        sb.append("Address: ").append(address).append(";\n");
        sb.append("Penthouse area: ").append(area).append(" sq feet;\n");
        sb.append("Bedrooms: ").append(bedroomsNum).append(";\n");
        sb.append("Infrastructure: \n");
        if (infrastructureObjectList.size() != 0){
            for (InfrastructureObject temp : infrastructureObjectList){
                sb.append("  Distance to ").append(temp.getInfrastructureObjectType().toString().toLowerCase()).append(" - ").append(temp.getDistance()).append(" m;\n");
            }
        }else{
            sb.append("  There are no infrastructure objects nearby;\n");
        }
        sb.append("Floor: ").append(floorNum).append(";\n");
        sb.append("Terrase: ");
        if (hasTerrace){
            sb.append("available").append(";\n");
        }else{
            sb.append("not available").append(";\n");
        }
        sb.append("Price: ").append(price).append("$;\n");
        return sb.toString();
    }
}
