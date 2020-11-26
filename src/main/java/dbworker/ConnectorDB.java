package dbworker;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectorDB {
    private Connection connection;
    public ConnectorDB(String adr,String scheme, String userName,String Password)
    {
        connection = getConnection(adr,scheme,userName,Password);
    }
    public Connection getConnectionNow()
    {
        return connection;
    }

    private  Connection getConnection(String adr,String scheme, String userName,String Password)
    {
        try {
           /*Class driver_class = Class.forName("com.mysql.jdbc.Driver");
            Driver driver =  (Driver)driver_class.getDeclaredConstructors().;
            DriverManager.registerDriver(driver);*/
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String url = "jdbc:mysql://" + adr + "/" + scheme+
                    "?verifyServerCertificate=false"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "&amp"+
                    "&serverTimezone=UTC";
            String name = "root";
            String pass = "root";
            //jdbc:mysql://localhost:3306/test"+
            Connection connection = DriverManager.getConnection(url, userName, Password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
