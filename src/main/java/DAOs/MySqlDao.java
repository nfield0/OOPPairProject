package DAOs;
import Exceptions.DaoException;

import java.sql.*;

public class MySqlDao  {
    public Connection getConnection() throws DaoException{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javaisp";
        String username = "root";
        String password = "";
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find driver class " + e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Connection failed " + e.getMessage());
            System.exit(2);
        }
        return connection;

    }
    public void freeConnection(Connection connection) throws DaoException
    {
        try
        {
            if (connection != null)
            {
                connection.close();
                connection = null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to free connection: " + e.getMessage());
            System.exit(1);
        }
    }
    public void errorHandling(ResultSet r, PreparedStatement p, Connection c) throws DaoException
    {

        try {
            if(r != null)
            {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                freeConnection(c);
            }
        } catch (SQLException e) {
            throw new DaoException(Thread.currentThread().getStackTrace()[1].getMethodName() + " " + e.getMessage());
        }
    }
    public void errorHandlingNoResult(PreparedStatement p, Connection c) throws DaoException
    {

        try {
            if (p != null) {
                p.close();
            }
            if (c != null) {
                freeConnection(c);
            }
        } catch (SQLException e) {
            throw new DaoException(Thread.currentThread().getStackTrace()[1].getMethodName() + " " + e.getMessage());
        }
    }
}
