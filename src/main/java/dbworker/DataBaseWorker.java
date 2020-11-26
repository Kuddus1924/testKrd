package dbworker;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseWorker {
    private ConnectorDB connection;
    public DataBaseWorker(ConnectorDB connectorDB){
        connection = connectorDB;

    }
    public ArrayList<Integer> getAllRecord()
    {
        try {
            ArrayList<Integer> record = (new RowDAO(connection.getConnectionNow())).selectData("test","field");
            return record;
        }
        catch (SQLException e)
        {
            System.out.println(e.getSQLState());
            return null;
        }
    }
    public void insertNRecords(int n)
    {
        try{
            connection.getConnectionNow().setAutoCommit(false);
            RowDAO dao = new RowDAO(connection.getConnectionNow());
            for(int i = 1;i <= n; i++) {
                dao.insert(i);
            }
            connection.getConnectionNow().commit();
        }
        catch (SQLException e)
        {
            System.out.println(e.getSQLState());
        }
    }
    public boolean isEmpty() {
        try {
            return  (new RowDAO(connection.getConnectionNow())).emprtyTable();
        }
        catch (SQLException e)
        {
            System.out.println(e.getSQLState());
            return false;
        }
    }
    public void deletaRecords()
    {
        try {
            new RowDAO(connection.getConnectionNow()).deleteAll();
        }
        catch (SQLException e)
        {
            System.out.println(e.getSQLState());
        }
    }

}
