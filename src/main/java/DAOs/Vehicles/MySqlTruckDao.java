package DAOs.Vehicles;

import DAOs.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.MySqlDealerDao;
import DTOs.Dealer;
import DTOs.Truck;
import DTOs.Vehicle;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTruckDao extends MySqlDao implements TruckDaoInterface {


    public List<Truck> findAllTrucks() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Truck> list = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM trucks;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

                list.add((Truck) createVehicle(rs));
            }


        } catch (SQLException e) {
            throw new DaoException("findAllTrucks() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public void insertTruck(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int weight_capacity) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO trucks VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            ps = conn.prepareStatement(query);

            setVehicle(ps,type,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(14, weight_capacity);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertTruck() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }
    public Vehicle createVehicle(ResultSet rs) throws SQLException {
        DealerDaoInterface dealerDao = new MySqlDealerDao();
        int id = rs.getInt("vehicle_id");
        String type = rs.getString("type");
        String make = rs.getString("make");
        String model = rs.getString("model");
        String engine = rs.getString("engine");
        String registration = rs.getString("registration");
        String color = rs.getString("color");
        int weight = rs.getInt("weight_tonnes");
        int number_passengers = rs.getInt("number_passengers");
        int mileage = rs.getInt("mileage");
        int price = rs.getInt("price");
        String fuel_type = rs.getString("fuel_type");
        //find dealer
        int dealer_id = rs.getInt("dealer_id");
        Dealer dealer = dealerDao.findDealerById(dealer_id);
        String imgUrl = rs.getString("img_url");
        int weight_capacity = rs.getInt("weight_capacity");
        return new Truck(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,weight_capacity);
    }
}
