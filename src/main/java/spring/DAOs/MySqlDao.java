package spring.DAOs;
import spring.DTOs.Dealer;
import spring.Exceptions.DaoException;

import java.sql.*;

public class MySqlDao  {
    public Connection getConnection() throws DaoException{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javaisp?allowMultiQueries=true";
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
    public void setVehicle(PreparedStatement ps, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl) throws SQLException {
        ps.setString(1, make);
        ps.setString(2, model);
        ps.setString(3, engine);
        ps.setString(4, registration);
        ps.setString(5, color);
        ps.setDouble(6, weightInTonnes);
        ps.setInt(7, numPassengers);
        ps.setInt(8, mileage);
        ps.setInt(9, price);
        ps.setString(10, fuelType);
        ps.setInt(11, dealer.getId());
        ps.setString(12, imgUrl);
    }
    public void setVehicle(PreparedStatement ps, int id, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl) throws SQLException {
        ps.setInt(1, id);
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
    public void deleteById(String tableName, String idColumn, int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int result;

        try {
            conn = this.getConnection();

            String query = "START TRANSACTION;" +
                    "DELETE FROM rental WHERE " + idColumn + " = ?;" +
                    "DELETE FROM " + tableName +" WHERE " + idColumn + " = ?;" +
                    "DELETE FROM vehicles WHERE " + idColumn + " = ?;" +
                    "COMMIT;";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2,id);
            ps.setInt(3,id);

            result = ps.executeUpdate();
            if(result != 0)
            {
                System.out.println("Deleted item from " + tableName );
            }
            else{
                System.out.println("Item from " + tableName + " does not exist");
            }


        } catch (SQLException e) {
            throw new DaoException("deleteById() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
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
