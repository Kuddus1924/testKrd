package converter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

public class Parser {
    public static Collection<Integer> doParse(String sequenceXmlFilePath) {
        Collection<Integer> parsedSequence = new ArrayList<>();

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser;
            parser = factory.createXMLStreamReader(
                    new BufferedInputStream(new FileInputStream(sequenceXmlFilePath)));

            while (parser.hasNext()) {
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("entry")) {
                        String intValueInAttribute = parser.getAttributeValue(null, "field");
                        if (intValueInAttribute != null) {
                            parsedSequence.add(Integer.parseInt(intValueInAttribute));
                        }
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return parsedSequence;
    }
}
