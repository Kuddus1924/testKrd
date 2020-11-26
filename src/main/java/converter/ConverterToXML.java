package converter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConverterToXML {
    public static void convertToXML(ArrayList<Integer> list, String filename) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\"?>\n");
        stringBuilder.append("<entries>\n");
        for(int i = 0;i < list.size();i ++)
        {
            stringBuilder.append("<entry>\n");
            stringBuilder.append("<field>");
            stringBuilder.append(list.get(i).toString());
            stringBuilder.append("</field>\n");
            stringBuilder.append("</entry>\n");
        }
        stringBuilder.append("</entries>\n");
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
