package directory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;


 public class AddressTask extends AddressParseXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            AddressParseXml handler = new AddressParseXml();
            parser.parse(new File("address.xml"), handler);

//Были проблемы с кодировкой
            File file = new File("address.xml");
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            parser.parse(is, handler);

//Выявляем повторы в названиях и их количество
            System.out.println("Повторы в названиях");
            for (Map.Entry<String, Integer> entry : addrMap.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey() + " : количество повторений: " + entry.getValue());
                }
            }
            addrMap.clear();

//Выявляем сколько n-этажных зданий в каждом городе
            for (int f = 1; f < 6; f++) {
                System.out.println("\n---------------");
                System.out.println(f + "-этажные:");
                for (AddressData a : addrList) {
                    if (a.getFloor() == f) {
                        if (addrMap.containsKey(a.getCity())) {
                            addrMap.put(a.getCity(), addrMap.get(a.getCity()) + 1);
                        } else addrMap.put(a.getCity(), 1);
                    }
                }

                for (Map.Entry<String, Integer> entry : addrMap.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
                addrMap.clear();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}



