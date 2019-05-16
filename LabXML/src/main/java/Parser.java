import SAXParser.SAXGunParser;
import comparator.GunsComparator;
import dom.DOMGunParser;
import extensionchecker.ExtensionChecker;
import model.Gun;
import stax.STAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    private static boolean checkIfXSD(File xsd) {
        return ExtensionChecker.isXSD(xsd);
    }

    private static boolean checkIfXML(File xml) {
        return ExtensionChecker.isXML(xml);
    }

    private static void printList(List<Gun> guns, String parserName) {
        GunsComparator gunsComparator = new GunsComparator();
        if (guns != null){
            Collections.sort(guns, gunsComparator);
            System.out.println(parserName);
            for (Gun gun : guns) {
                System.out.println(gun);
            }
        }
    }

    public static void main(String[] args) {
        File xml = new File("src/main/resources/xmls/gunsPrint.xml");
        File xsd = new File("src/main/resources/xmls/guns.xsd");

        if (checkIfXML(xml) && checkIfXSD(xsd)) {
//            SAX
            printList(STAXReader.parseGuns(xml,xsd), "STAX");

        }
}

}
