package DAOs;
import DTOs.Car;
import DTOs.Dealer;
import DTOs.Vehicle;
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
    public void setVehicle(PreparedStatement ps, String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl) throws SQLException {
        ps.setString(1, type);
        ps.setString(2, make);
        ps.setString(3, model);
        ps.setString(4, engine);
        ps.setString(5, registration);
        ps.setString(6, color);
        ps.setDouble(7, weightInTonnes);
        ps.setInt(8, numPassengers);
        ps.setInt(9, mileage);
        ps.setInt(10, price);
        ps.setString(11, fuelType);
        ps.setInt(12, dealer.getId());
        ps.setString(13, imgUrl);
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
