package growepam.gemstones.gemstone;

import java.util.*;

//This class consists of list of gemstones and mathods that help in managing this list
public class GemstoneManager {
    private static Scanner scan = new Scanner(System.in);
    private static List<Gemstone> gemstonesList = new ArrayList<>(Arrays.asList(
            new Gemstone("DIAMOND", Valuation.PRECIOUS, Clarity.TRANSPARENT,9050),
            new Gemstone("RUBY",Valuation.PRECIOUS,Clarity.TRANSCLUENT,6500),
            new Gemstone("SAPPHIRE",Valuation.PRECIOUS,Clarity.TRANSPARENT,7000),
            new Gemstone("ALEXANDRITE",Valuation.PRECIOUS,Clarity.TRANSPARENT,5000),
            new Gemstone("EMERALD",Valuation.SEMIPRECIOUS,Clarity.TRANSPARENT,4000),
            new Gemstone("AGATE",Valuation.SEMIPRECIOUS,Clarity.OPAQUE,1000),
            new Gemstone("AMAZONITE",Valuation.SEMIPRECIOUS,Clarity.OPAQUE,500),
            new Gemstone("AMBER",Valuation.SEMIPRECIOUS,Clarity.TRANSCLUENT,1100),
            new Gemstone("AMETHYST",Valuation.PRECIOUS,Clarity.TRANSPARENT,3000),
            new Gemstone("CITRINE",Valuation.SEMIPRECIOUS,Clarity.TRANSPARENT,1700),
            new Gemstone("AMETRINE",Valuation.PRECIOUS,Clarity.TRANSPARENT,2700),
            new Gemstone("AQUAMARINE",Valuation.PRECIOUS,Clarity.TRANSPARENT,2000)));

    //Returns full list of gemstones
    public static List<Gemstone> getGemstonesList() {
        return gemstonesList;
    }

    //Returns list only of gemstones that have specified clarity
    public static List<Gemstone> getGemtonesByClarity(Clarity clarity){
        if (clarity == null){
            System.out.println("There is no specified clarity");
            return null;
        }
        List<Gemstone>  gemstonesByClarity = new LinkedList<>();
        for (Gemstone stone : new ArrayList<>(gemstonesList)){
            if (stone.getClarity().equals(clarity)){
                gemstonesByClarity.add(stone);
            }
        }
        return gemstonesByClarity;
    }

    //Returns gemstone by its name and returns null if there is no gemstone of this name
    public static Gemstone getGemstoneByName(String gemstoneName){
        if (gemstoneName == null){
            System.out.println("There is no specified gemstone name");
            return null;
        }
        Gemstone requestedGemstone = null;
        for (Gemstone tempGemstone : gemstonesList){
            if (tempGemstone.getName().equals(gemstoneName)){
                requestedGemstone = tempGemstone;
                break;
            }
        }
        if (requestedGemstone == null){
            System.out.println("There is no gemstone with such name present on the list");
        }
        return requestedGemstone;
    }

    public static  <T> void printCollection(Collection<T> collection){
        if ((collection == null) || (collection.size() == 0)){
            System.out.println("Nothing on the list\n");
            return;
        }
        for (T tempProduct : collection){
            System.out.println(tempProduct);
        }
    }
}
