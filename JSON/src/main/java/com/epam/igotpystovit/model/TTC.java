package com.epam.igotpystovit.model;

public class TTC {
    private RangeType rangeType;
    private int range;
    private int sightseeingRange;
    private boolean isClipped;
    private boolean isOptical;

    public TTC(){}
    public TTC(RangeType rangeType, int range, int sightseeingRange, boolean isClipped, boolean isOptical){
        this.rangeType = rangeType;
        this.range = range;
        this.sightseeingRange = sightseeingRange;
        this.isClipped = isClipped;
        this.isOptical = isOptical;
    }

    public int getRange() {
        return range;
    }

    public int getSightseeingRange() {
        return sightseeingRange;
    }

    public RangeType getRangeType() {
        return rangeType;
    }

    public boolean isClipped() {
        return isClipped;
    }

    public boolean isOptical() {
        return isOptical;
    }

    public void setOptical(boolean optical) {
        isOptical = optical;
    }

    public void setClipped(boolean clipped) {
        isClipped = clipped;
    }

    public void setRangeType(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    public void setSightseeingRange(int sightseeingRange) {
        this.sightseeingRange = sightseeingRange;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("TTC{\n");
        sb.append("  Range type:"+rangeType.toString().toLowerCase()+";\n");
        sb.append("  Range (meters):"+range+";\n");
        sb.append("  Sightseeing range (meters):"+ sightseeingRange +";\n");
        sb.append("  Clip availability:");
        if (isClipped){
            sb.append("available;\n");
        }
        else{
            sb.append("not available;\n");
        }
        sb.append("  Optics availability:");
        if (isOptical){
            sb.append("available;\n");
        }
        else {
            sb.append("not available;\n");
        }
        sb.append(" }");
        return sb.toString();
    }
}
