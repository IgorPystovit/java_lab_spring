package growepam.gemstones.gemstone;

//This class represents gemstones properties
//It also overrides equals method
public class Gemstone implements Comparable<Gemstone>{
    private double price;
    private Clarity clarity;
    private Valuation valuation;
    private String stoneName;

    public Gemstone(){}
    public Gemstone(String stoneName, Valuation valuation, Clarity clarity, double price){
        this.stoneName = stoneName;
        this.valuation = valuation;
        this.clarity = clarity;
        this.price = price;
    }

    @Override
    public int compareTo(Gemstone gemstone){
        int compareNum = 0;

        if (this.price < gemstone.price){
            compareNum = -1;
        } else if (this.price > gemstone.price){
            compareNum = 1;
        }

        return compareNum;
    }

    public String getName() {
        return stoneName;
    }

    public Valuation getValuation() {
        return valuation;
    }

    public Clarity getClarity() {
        return clarity;
    }

    public double getPrice() {
        return price;
    }

    //Overrides equals method and make if consider two gemstones as equal only if their stoneName attributes are the same
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if (!(o instanceof Gemstone)){
            return false;
        }

        return stoneName.equals(((Gemstone) o).stoneName);

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nGemstone name: ").append(stoneName.toLowerCase()).append(";\n");
        sb.append("Clarity: ").append(clarity.toString().toLowerCase()).append(";\n");
        sb.append("Valuation: ").append(valuation.toString().toLowerCase()).append(";\n");
        sb.append("Price: ").append(price).append(" $ per carat;\n");
        return sb.toString();
    }
}
