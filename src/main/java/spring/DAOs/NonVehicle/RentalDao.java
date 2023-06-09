package spring.DAOs.NonVehicle;

import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.NonVehicle.Interfaces.RentalDaoInterface;
import spring.DAOs.NonVehicle.Interfaces.UserDaoInterface;
import spring.DAOs.Vehicles.Interfaces.VehicleDaoInterface;
import spring.DAOs.Vehicles.MySqlVehicleDao;
import spring.DTOs.Dealer;
import spring.DTOs.User;
import spring.DTOs.Vehicle;
import spring.DTOs.VehicleRental;
import spring.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalDao extends MySqlDao implements RentalDaoInterface {
    UserDaoInterface uDao = new MySqlUserDao();
    VehicleDaoInterface vDao = new MySqlVehicleDao();
    DealerDaoInterface dDao = new MySqlDealerDao();
    public VehicleRental insertRental(int userId, int vehicleId, int dealerId,int durationDays) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs;
        VehicleRental v = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO RENTAL VALUES (null,?,?,?,?,?,?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, vehicleId);
            ps.setInt(3, dealerId);
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(5, durationDays);
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));

            rs = ps.executeUpdate();

            if(rs == 1) {
                User u = uDao.findUserById(userId);
                Vehicle j = vDao.findVehicleById(vehicleId);
                Dealer d = dDao.findDealerById(dealerId);
                v = new VehicleRental(u,j,d,durationDays);
            }
                return v;


        } catch (SQLException e) {
            throw new DaoException("insertUser() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);

        }


    }

    public List<VehicleRental> findAllRentals() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VehicleRental> rentals = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM RENTAL";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int vid = rs.getInt("vehicle_id");
                int did = rs.getInt("dealer_id");
                Date start_date = rs.getDate("start_date");
                int duration = rs.getInt("duration_days");
                LocalDateTime created = rs.getTimestamp("created_date").toLocalDateTime();


                User u = uDao.findUserById(uid);
                Vehicle v = vDao.findVehicleById(vid);
                Dealer d = dDao.findDealerById(did);
                VehicleRental r = new VehicleRental(id,u,v,d,start_date,duration,created);
                rentals.add(r);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllRentals() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return rentals;

    }
    public List<VehicleRental> findRentalByVehicleId(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VehicleRental> rentals = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM RENTAL WHERE vehicle_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while(rs.next())
            {
                int oid = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int vid = rs.getInt("vehicle_id");
                int did = rs.getInt("dealer_id");
                Date start_date = rs.getDate("start_date");
                int duration = rs.getInt("duration_days");
                LocalDateTime created = rs.getTimestamp("created_date").toLocalDateTime();


                User u = uDao.findUserById(uid);
                Vehicle v = vDao.findVehicleById(vid);
                Dealer d = dDao.findDealerById(did);
                VehicleRental r = new VehicleRental(oid,u,v,d,start_date,duration,created);
                rentals.add(r);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllRentalsByVehicleId() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return rentals;
    }
    public List<VehicleRental> findRentalByUserId(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VehicleRental> rentals = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM RENTAL WHERE user_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);


            rs = ps.executeQuery();
            while(rs.next())
            {
                int oid = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int vid = rs.getInt("vehicle_id");
                int did = rs.getInt("dealer_id");
                Date start_date = rs.getDate("start_date");
                int duration = rs.getInt("duration_days");
                LocalDateTime created = rs.getTimestamp("created_date").toLocalDateTime();


                User u = uDao.findUserById(uid);
                Vehicle v = vDao.findVehicleById(vid);
                Dealer d = dDao.findDealerById(did);
                VehicleRental r = new VehicleRental(oid,u,v,d,start_date,duration,created);
                rentals.add(r);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllRentalsByUserId() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return rentals;
    }

    public VehicleRental findRentalById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        VehicleRental rental = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM RENTAL WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while(rs.next())
            {
                int oid = rs.getInt("id");
                int uid = rs.getInt("user_id");
                int vid = rs.getInt("vehicle_id");
                int did = rs.getInt("dealer_id");
                Date start_date = rs.getDate("start_date");
                int duration = rs.getInt("duration_days");
                LocalDateTime created = rs.getTimestamp("created_date").toLocalDateTime();


                User u = uDao.findUserById(uid);
                Vehicle v = vDao.findVehicleById(vid);
                Dealer d = dDao.findDealerById(did);
                rental = new VehicleRental(oid,u,v,d,start_date,duration,created);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllRentalsById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return rental;
    }
    public void deleteById(int id) throws DaoException {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("rental","id",id);
    }
}
