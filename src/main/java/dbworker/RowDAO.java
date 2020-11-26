package dbworker;
import executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RowDAO {
    private Executor executor;
    public RowDAO(Connection connection) {
        executor = new Executor(connection);
    }
    public void insert(int num) throws SQLException
    {
        executor.execUpdate("insert into TEST (field) values ('"+ num +"')");
    }
    public void deleteAll() throws SQLException
    {
        executor.execUpdate("delete from TEST");
    }
    public boolean emprtyTable()throws SQLException
    {
        ArrayList <Integer> res = executor.execQuery("select count(*) from TEST",result -> {
            ArrayList<Integer> results = new ArrayList<Integer>();
            while(result.next()) {
                results.add(result.getInt(1));
            }
            return results;
        });
        if (res.get(0) == 0)
            return true;
        else
            return false;
    }
    public ArrayList<Integer> selectData(String table,String field)throws SQLException
    {

        return executor.execQuery("select " +  field +" from " + table,result -> {
            ArrayList<Integer> results = new ArrayList<Integer>();
            while(result.next()) {
                results.add(result.getInt(1));
            }
            return results;
        });

    }


}
