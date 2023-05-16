package spring.DAOs.Vehicles;

import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.MySqlDealerDao;
import spring.DAOs.Vehicles.Interfaces.PlaneDaoInterface;
import spring.DTOs.Dealer;
import spring.DTOs.Plane;
import spring.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPlaneDao extends MySqlDao implements PlaneDaoInterface {


    public List<Plane> findAllPlanes() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Plane> list = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM airplanes;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

                list.add(createVehicle(rs));
            }


        } catch (SQLException e) {
            throw new DaoException("findAllPlanes() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public void insertPlane(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numEngines,int range, int max_speed_knots, int seating_capacity) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = """
                    START TRANSACTION;
                    INSERT INTO vehicles (type) VALUES
                    ('Airplane');
                    INSERT INTO airplanes (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,engine_count,flightRange,max_speed_knots,seating_capacity)
                    VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?);
                    COMMIT;""";
            ps = conn.prepareStatement(query);

            setVehicle(ps,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(13, numEngines);
            ps.setInt(14, range);
            ps.setInt(15, max_speed_knots);
            ps.setInt(16, seating_capacity);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertPlane() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }
    public void insertPlane(Plane p) throws DaoException
    {
        insertPlane(p.getMake(),p.getModel(),p.getEngine(),p.getRegistration(),p.getColor(),p.getWeightInTonnes(),p.getNumPassengers(),p.getMileage(),p.getPrice(),p.getFuelType(),p.getDealer(),p.getImgUrl(),p.getNumEngines(),p.getRange(),p.getMax_speed_knots(),p.getSeating_capacity());
    }


    public void deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("airplanes","vehicle_id",id);
    }
    public Plane createVehicle(ResultSet rs) throws SQLException {
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
        int numEngines = rs.getInt("engine_count");
        int range = rs.getInt("flightRange");
        int max_speed_knots = rs.getInt("max_speed_knots");
        int seating_capacity = rs.getInt("seating_capacity");

        return new Plane(id,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,numEngines,range,max_speed_knots,seating_capacity);
    }
}
