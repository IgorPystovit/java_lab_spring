package comparator;

import model.Gun;

import java.util.Comparator;

public class GunsComparator implements Comparator<Gun> {
    public GunsComparator(){}
    @Override
    public int compare(Gun o,Gun o2){
        return Integer.compare(o.getTtc().getSightingRange(),o2.getTtc().getSightingRange());
    }
}
