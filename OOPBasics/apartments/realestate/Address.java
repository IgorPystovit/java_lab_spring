package growepam.apartments.realestate;

//This class represents address
//It consists of country, town,street and house namber attributes
public class Address {
    private String country;
    private String town;
    private String street;
    private int houseNumber;

    public Address(){}
    public Address(String country,String town,String street,int houseNumber){
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(country).append(", ").append(town).append(", ").append(street).append(" ").append(houseNumber);
        return sb.toString();
    }
}
