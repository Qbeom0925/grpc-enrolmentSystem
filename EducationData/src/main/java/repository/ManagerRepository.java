package repository;

import global.util.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerRepository {

    private final Connection connection;

    public ManagerRepository() {
        this.connection = SqlConnection.connection();
    }


    public boolean getManager(String id) {
        String sql = "select count(*) from MANAGER where login_id=?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) if(rs.getInt("count(*)")==1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
