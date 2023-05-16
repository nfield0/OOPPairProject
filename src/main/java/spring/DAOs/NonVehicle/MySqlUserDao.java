package spring.DAOs.NonVehicle;

import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.Interfaces.UserDaoInterface;
import spring.DTOs.User;
import spring.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao extends MySqlDao implements UserDaoInterface {

    public void insertUser(int id, String name, String email, String password, int admin) throws DaoException {
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
            errorHandlingNoResult(ps,conn);
        }


    }
    public User insertUser(User u) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO USERS VALUES (?,?,?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getAdmin());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertUser() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


        return u;
    }
    public List<User> findAllUsers() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM USERS";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");

                User u = new User(id,name,email,password,admin);
                users.add(u);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllUsers() " + e.getMessage());
        } finally {
                errorHandling(rs,ps,conn);
        }
        return users;
    }
    public User findUserById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM users where user_id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()){
                int uid = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");

                return new User(uid,name,email,password,admin);
            }

        } catch (SQLException e) {
            throw new DaoException("findUserById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return null;
    }
    public User deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("users","vehicle_id",id);
        return null;
    }
}