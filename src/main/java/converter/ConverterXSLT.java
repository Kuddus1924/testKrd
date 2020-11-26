package converter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Collection;

public class ConverterXSLT {
    public static void convert(String INfile,String OUTfile)
    {
        String style = "trans.xslt";
        try {
            File stylesheet = new File(style);
            StreamSource styleSource = new StreamSource(stylesheet);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(new StreamSource(
                            new BufferedInputStream(new FileInputStream(INfile))),
                    new StreamResult(new FileOutputStream(OUTfile))
            );

            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(OUTfile));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public  static Collection<Integer> doParse(String fileName)  {
        return Parser.doParse(fileName);
    }

    public  static long sum(Collection<Integer> collection) {
        return collection.stream().mapToInt(i -> i).sum();
    }
}
