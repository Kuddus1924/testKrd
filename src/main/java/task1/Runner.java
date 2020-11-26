package task1;

import converter.ConverterToXML;
import converter.ConverterXSLT;
import dbworker.ConnectorDB;
import dbworker.DataBaseWorker;

public class Runner {
    public void runTask1(int n,String adr,String shema, String userName, String password) {
        ConnectorDB connectorDB = new ConnectorDB(adr,shema,userName,password);
        DataBaseWorker dataBaseWorker = new DataBaseWorker(connectorDB);
       if(!dataBaseWorker.isEmpty())
        {
            dataBaseWorker.deletaRecords();
        }
        dataBaseWorker.insertNRecords(n);
        try {
            /*connectorDB = new ConnectorDB();
            dataBaseWorker = new DataBaseWorker(connectorDB);*/
            ConverterToXML.convertToXML(dataBaseWorker.getAllRecord(), "1.xml");
            ConverterXSLT.convert("1.xml", "2.xml");
            System.out.println(ConverterXSLT.sum(ConverterXSLT.doParse("2.xml")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

