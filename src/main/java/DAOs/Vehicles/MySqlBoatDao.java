package DAOs.Vehicles;

import DAOs.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.MySqlDealerDao;
import DTOs.Boat;
import DTOs.Car;
import DTOs.Dealer;
import DTOs.Vehicle;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlBoatDao extends MySqlDao implements BoatDaoInterface {


    public List<Boat> findAllBoats() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Boat> list = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM boats;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

                list.add((Boat) createVehicle(rs));
            }


        } catch (SQLException e) {
            throw new DaoException("findAllBoats() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public void insertBoat(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numberLifeBoats, int max_speed_knots) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO boats VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            ps = conn.prepareStatement(query);

            setVehicle(ps,type,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(14, numberLifeBoats);
            ps.setInt(15, max_speed_knots);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertBoat() " + e.getMessage());
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
        int numLifeBoats = rs.getInt("number_lifeboats");
        int max_speed_knots = rs.getInt("max_speed_knots");
        return new Boat(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,numLifeBoats,max_speed_knots);
    }
}
