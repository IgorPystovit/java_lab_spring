package dom;

import model.Gun;
import model.Handy;
import model.RangeType;
import model.TTC;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocReader {
    public List<Gun> readDoc(Document doc){
        doc.getDocumentElement().normalize();
        List<Gun> guns = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("gun");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Gun gun = new Gun();
            TTC ttc;

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                gun.setModel(element.getElementsByTagName("model").item(0).getTextContent());
                gun.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                gun.setMaterial(element.getElementsByTagName("material").item(0).getTextContent());
                gun.setHandy(Handy.valueOf(element.getElementsByTagName("handy").item(0).getTextContent()));

                gun.setTtc(getTTC(element.getElementsByTagName("ttc")));
                guns.add(gun);
            }
        }
        return guns;
    }

    private TTC getTTC(NodeList nodes) {
        TTC ttc = new TTC();
        if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element)nodes;
            ttc.setRangeType(RangeType.valueOf(element.getElementsByTagName("rangetype").item(0).getTextContent()));
            ttc.setRange(Integer.parseInt(element.getElementsByTagName("range").item(0).getTextContent()));
            ttc.setSightingRange(Integer.parseInt(element.getElementsByTagName("sightseeingRange").item(0).getTextContent()));
            if(element.getElementsByTagName("clipped").item(0).getTextContent().equals("available")){
                ttc.setClipped(true);
            }else {
                ttc.setClipped(false);
            }
            if(element.getElementsByTagName("optical").item(0).getTextContent().equals("available")){
                ttc.setOptical(true);
            }else{
                ttc.setOptical(false);
            }
        }
        return ttc;
    }
}
