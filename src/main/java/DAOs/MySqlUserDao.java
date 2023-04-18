package DAOs;

import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlUserDao extends MySqlDao {

    public void insertUser(int id, String name, String email, String password, int admin) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO USERS VALUES (?,?,?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, admin);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertUser() " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                throw new DaoException("insertUser() " + e.getMessage());
            }
        }


    }
}
