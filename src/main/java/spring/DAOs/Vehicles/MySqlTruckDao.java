package spring.DAOs.Vehicles;

import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.MySqlDao;
import spring.DAOs.NonVehicle.MySqlDealerDao;
import spring.DAOs.Vehicles.Interfaces.TruckDaoInterface;
import spring.DTOs.Car;
import spring.DTOs.Dealer;
import spring.DTOs.Truck;
import spring.DTOs.Vehicle;
import spring.Exceptions.DaoException;

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

                list.add(createVehicle(rs));
            }


        } catch (SQLException e) {
            throw new DaoException("findAllTrucks() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public void insertTruck(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int weight_capacity) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = """
                    START TRANSACTION;
                    INSERT INTO vehicles (type) VALUES
                    ('Truck');
                    INSERT INTO trucks (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,weight_capacity)
                    VALUES (LAST_INSERT_ID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);
                    COMMIT;""";
            ps = conn.prepareStatement(query);

            setVehicle(ps,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(13, weight_capacity);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertTruck() " + e.getMessage());
        } finally {
            errorHandlingNoResult(ps,conn);
        }


    }
    public void insertTruck(Truck t) throws DaoException
    {
        insertTruck(t.getMake(),t.getModel(),t.getEngine(),t.getRegistration(),t.getColor(),t.getWeightInTonnes(),t.getNumPassengers(),t.getMileage(),t.getPrice(),t.getFuelType(),t.getDealer(),t.getImgUrl(),t.getWeight_capacity());
    }
    public void updateTruck(int id, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int weight_capacity) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try

        {
            conn = this.getConnection();

            String query = """
                    UPDATE trucks
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
                             weight_capacity = ?                    
                         WHERE vehicle_id = ?;
                    """;
            ps = conn.prepareStatement(query);

            setVehicle(ps,id,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);

            ps.setInt(14, weight_capacity);


            ps.executeUpdate();
        } catch(
                SQLException e)

        {
            throw new DaoException("updateBoat() " + e.getMessage());
        } finally

        {
            errorHandlingNoResult(ps, conn);
        }
    }

    public void deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("trucks","vehicle_id",id);
    }
    public Truck findTruckById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Truck v = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM trucks where vehicle_id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()){
                v = createVehicle(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("findTruckById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return v;
    }
    public Truck createVehicle(ResultSet rs) throws SQLException {
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
        int weight_capacity = rs.getInt("weight_capacity");
        return new Truck(id,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,weight_capacity);
    }
}
