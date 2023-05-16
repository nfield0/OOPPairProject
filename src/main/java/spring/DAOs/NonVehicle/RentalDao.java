package spring.DAOs.NonVehicle;

import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.Interfaces.RentalDaoInterface;
import spring.DTOs.VehicleRental;
import spring.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDao extends MySqlDao implements RentalDaoInterface {

    public void insertRental() throws DaoException
    {

    }

    public List<VehicleRental> findAllRentals() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VehicleRental> rentals = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM RENTALS";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int admin = rs.getInt("admin");


//                VehicleRental r = new VehicleRental(id,user);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllRentals() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return rentals;

    }

    @Override
    public VehicleRental findRentalById(int id) throws DaoException {
        return null;
    }

    @Override
    public void deleteById(int id) throws DaoException {

    }
}
