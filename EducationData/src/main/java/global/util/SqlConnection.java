package global.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection{

    public static Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://mehdb.cengwcl4wnom.ap-northeast-2.rds.amazonaws.co:3306/educ?",
                    "admin",
                    "mehmeh123");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
