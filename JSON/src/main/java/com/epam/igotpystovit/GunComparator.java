package com.epam.igotpystovit;

import com.epam.igotpystovit.model.Gun;

import java.util.Comparator;

public class GunComparator implements Comparator<Gun> {
    public int compare(Gun o1,Gun o2){
        return Double.compare(o1.getTtc().getRange(),o2.getTtc().getRange());
    }
}
