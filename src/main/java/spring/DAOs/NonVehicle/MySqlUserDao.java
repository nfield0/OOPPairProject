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
    public User insertUser(String name, String email, String password) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO USERS VALUES (null,?,?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, 0);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertUser() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }

        return null;
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

            String query = "SELECT * FROM users where id = ?";

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
    public User findUserByEmailAndPassword(String cEmail, String cPassword) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM users where email = ? and password = ?;";

            ps = conn.prepareStatement(query);
            ps.setString(1,cEmail);
            ps.setString(2,cPassword);
            System.out.println(ps);
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
    public User deleteUserById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int result;

        try {
            conn = this.getConnection();

            String query = "START TRANSACTION;" +
                    "DELETE FROM rental WHERE user_id = ?;" +
                    "DELETE FROM users WHERE id = ?;" +
                    "COMMIT;";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2,id);

            result = ps.executeUpdate();
            if(result != 0)
            {
                System.out.println("Deleted item from users" );
            }
            else{
                System.out.println("Item from Users does not exist");
            }


        } catch (SQLException e) {
            throw new DaoException("deleteById() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }
        return null;
    }
}
