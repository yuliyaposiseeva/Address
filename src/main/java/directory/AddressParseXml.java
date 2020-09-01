package directory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AddressParseXml extends DefaultHandler {
    public static Map<String, Integer> addrMap = new HashMap<>();
    public static ArrayList<AddressData> addrList = new ArrayList<>();
    private static AddressData data = null;


    // Получаем атрибуты элемента Item
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("item")) {
                data = new AddressData();
                data.setCity(attributes.getValue("city"));
                data.setStreet(attributes.getValue("street"));
                data.setHouse(attributes.getValue("house"));
                data.setFloor(Integer.parseInt(attributes.getValue("floor")));
            }
        }

        @Override
        public void endElement (String uri, String localName, String qName){
            if (qName.equals("item")) {
                if (addrMap.containsKey(data.toString())) {
                    addrMap.put(data.toString(), addrMap.get(data.toString()) + 1);
                } else {
                    addrMap.put(data.toString(), 1);
                    addrList.add(data);
                }
            }
        }
    }