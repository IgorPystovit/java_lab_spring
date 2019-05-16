package SAXParser;

import model.Gun;
import model.Handy;
import model.RangeType;
import model.TTC;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Gun> guns = new ArrayList<>();
    private Gun gun;
    private TTC ttc;
    private StringBuilder stringBuilder = null;
    private boolean bModel;
    private boolean bOrigin;
    private boolean bHandy;
    private boolean bMaterial;
    private boolean bTTC;
    private boolean bRangeType;
    private boolean bRange;
    private boolean bSighseeingRange;
    private boolean bIsClipped;
    private boolean bIsOptical;

    public List<Gun> getGuns(){
        return guns;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("gun")){
            gun = new Gun();
        }
        else if(qName.equalsIgnoreCase("model")){
            bModel = true;
        }
        else if(qName.equalsIgnoreCase("handy")){
            bHandy = true;
        }
        else if(qName.equalsIgnoreCase("origin")){
            bOrigin = true;
        }
        else if(qName.equalsIgnoreCase("material")){
            bMaterial = true;
        }
        else if(qName.equalsIgnoreCase("ttc")){
            bTTC = true;
        }
        else if(qName.equalsIgnoreCase("rangetype")){
            bRangeType = true;
        }
        else if(qName.equalsIgnoreCase("range")){
            bRange = true;
        }
        else if(qName.equalsIgnoreCase("sightseeingRange")){
            bSighseeingRange = true;
        }
        else if(qName.equalsIgnoreCase("clipped")){
            bIsClipped = true;
        }
        else if(qName.equalsIgnoreCase("optical")){
            bIsOptical = true;
        }
        stringBuilder = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("gun")){
            guns.add(gun);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bModel){
            gun.setModel(new String(ch,start,length));
            bModel = false;
        }
        else if(bHandy){
            gun.setHandy(Handy.valueOf(new String(ch,start,length)));
            bHandy = false;
        }
        else if(bOrigin){
            gun.setOrigin(new String(ch,start,length));
            bOrigin = false;
        }
        else if(bMaterial){
            gun.setMaterial(new String(ch,start,length));
            bMaterial = false;
        }
        else if(bTTC){
            ttc = new TTC();
            gun.setTtc(ttc);
            bTTC = false;
        }
        else if(bRangeType){
            ttc.setRangeType(RangeType.valueOf(new String(ch,start,length)));
            bRangeType = false;
        }
        else if(bRange){
            ttc.setRange(Integer.parseInt(new String(ch,start,length)));
            bRange = false;
        }
        else if(bSighseeingRange){
            ttc.setSightingRange(Integer.parseInt(new String(ch,start,length)));
            bSighseeingRange = false;
        }
        else if(bIsClipped){
            ttc.setClipped(Boolean.parseBoolean(new String(ch,start,length)));
            bIsClipped = false;
        }
        else if(bIsOptical){
            ttc.setOptical(Boolean.parseBoolean(new String(ch,start,length)));
            bIsOptical = false;
        }
    }
}
