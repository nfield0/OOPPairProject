package spring.DAOs.Vehicles;

import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.MySqlDealerDao;
import spring.DAOs.Vehicles.Interfaces.BoatDaoInterface;
import spring.DTOs.Boat;
import spring.DTOs.Dealer;
import spring.Exceptions.DaoException;

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

                list.add( createVehicle(rs));
            }


        } catch (SQLException e) {
            throw new DaoException("findAllBoats() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public void insertBoat(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numberLifeBoats, int max_speed_knots) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = """
                    START TRANSACTION;
                    INSERT INTO vehicles (type) VALUES
                    ('Boat');
                    INSERT INTO boats (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,number_lifeboats,max_speed_knots)
                    VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?);
                    COMMIT;""";
            ps = conn.prepareStatement(query);

            setVehicle(ps,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(13, numberLifeBoats);
            ps.setInt(14, max_speed_knots);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertBoat() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }
    public void updateBoat(int id,String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numberLifeBoats, int max_speed_knots) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = """
                    UPDATE boats
                         SET make = ?,
                             model = ?,
                             engine = ?,
                             registration = ?,
                             color = ?,
                             weight_tonnes = ?,
                             number_passengers = ?,
                             mileage = ?,
                             price = ?,
                             fuel_type = ?,
                             dealer_id = ?,
                             img_url = ?,
                             number_lifeboats = ?,
                             max_speed_knots = ?
                         WHERE vehicle_id = ?;
                    """;
            ps = conn.prepareStatement(query);

            setVehicle(ps,id,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(14, numberLifeBoats);
            ps.setInt(15, max_speed_knots);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("updateBoat() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }
    public void insertBoat(Boat b) throws DaoException
    {
        insertBoat(b.getMake(),b.getModel(),b.getEngine(),b.getRegistration(),b.getColor(),b.getWeightInTonnes(),b.getNumPassengers(),b.getMileage(),b.getPrice(),b.getFuelType(),b.getDealer(),b.getImgUrl(),b.getNumLifeBoats(),b.getMax_speed_knots());
    }
    public Boat findBoatById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boat v = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM boats where vehicle_id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()){
                v = createVehicle(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("findBoatById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return v;
    }
    public void deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("boats","vehicle_id",id);
    }
    public Boat createVehicle(ResultSet rs) throws SQLException {
        DealerDaoInterface dealerDao = new MySqlDealerDao();
        int id = rs.getInt("vehicle_id");
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
        return new Boat(id,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,numLifeBoats,max_speed_knots);
    }
}
