package stax;

import model.Gun;
import model.Handy;
import model.RangeType;
import model.TTC;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class STAXReader {
    public static List<Gun> parseGuns(File xml, File xsd){
        List<Gun> gunList = new ArrayList<>();
        Gun gun = null;
        TTC ttc = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
            while(xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name){
                        case "gun":
                            gun = new Gun();
                            break;
                        case "model":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gun != null;
                            gun.setModel(xmlEvent.asCharacters().getData());
                            break;
                        case "handy":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gun != null;
                            gun.setHandy(Handy.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                            break;
                        case "origin":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gun != null;
                            gun.setOrigin(xmlEvent.asCharacters().getData());
                            break;
                        case "material":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert gun != null;
                            gun.setMaterial(xmlEvent.asCharacters().getData());
                            break;
                        case "ttc":
                            xmlEvent = xmlEventReader.nextEvent();
                            ttc = new TTC();
                            gun.setTtc(ttc);
                            break;
                        case "rangetype":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ttc != null;
                            ttc.setRangeType(RangeType.valueOf(xmlEvent.asCharacters().getData().toUpperCase()));
                            break;
                        case "range":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ttc != null;
                            ttc.setRange(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "sightseeingRange":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ttc != null;
                            ttc.setSightingRange(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "clipped":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ttc != null;
                            if (xmlEvent.asCharacters().getData().equals("available")){
                                ttc.setClipped(true);
                            }else {
                                ttc.setClipped(false);
                            }
                            break;
                        case "optical":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ttc != null;
                            if (xmlEvent.asCharacters().getData().equals("available")){
                                ttc.setOptical(true);
                            }else {
                                ttc.setOptical(false);
                            }
                            break;
                    }
                }
                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("gun")){
                        gunList.add(gun);
                    }
                }
            }
        }catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return gunList;
    }
}
