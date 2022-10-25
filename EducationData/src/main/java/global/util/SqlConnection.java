package global.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection{

    public static Connection connection(){
        try {
            Class.forName("org.h2.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/clsv",
                    "sa",
                    "");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
