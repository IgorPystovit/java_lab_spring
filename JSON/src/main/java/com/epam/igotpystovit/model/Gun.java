package com.epam.igotpystovit.model;

import com.google.gson.annotations.Expose;

public class Gun {
    private String model;
    @Expose
    private Handy handy;
    private String origin;
    private String material;
    private TTC ttc;

    public Gun(){}
    public Gun(String model, Handy handy, String origin, String material, TTC ttc){
        this.handy = handy;
        this.model = model;
        this.origin = origin;
        this.material = material;
        this.ttc = ttc;
    }

    public Handy getHandy() {
        return handy;
    }

    public String getMaterial() {
        return material;
    }

    public String getOrigin() {
        return origin;
    }

    public String getModel() {
        return model;
    }

    public TTC getTtc() {
        return ttc;
    }

    public void setTtc(TTC ttc) {
        this.ttc = ttc;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(model+"{\n");
        if (handy != null)
        sb.append(" Handy:"+handy.toString().toLowerCase()+";\n");
        sb.append(" Origin:"+origin+";\n");
        sb.append(" "+ttc+"\n");
        sb.append(" Material:"+material+";\n");
        sb.append("}\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        Gun gun = new Gun("M-16",Handy.TWO_HANDED,"USA","metal",new TTC(RangeType.LONG,900,1900,true,false));
        System.out.println(gun);
    }
}
