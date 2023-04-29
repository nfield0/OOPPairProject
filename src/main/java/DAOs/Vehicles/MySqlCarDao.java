package DAOs.Vehicles;

import DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.NonVehicle.MySqlDealerDao;
import DAOs.Vehicles.Interfaces.CarDaoInterface;
import DTOs.Car;
import DTOs.Dealer;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCarDao extends MySqlDao implements CarDaoInterface {

    public void insertCar(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer,String imgUrl, int numDoors) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO cars VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            setVehicle(ps,type,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl);
            ps.setInt(14, numDoors);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertCar() " + e.getMessage());
        } finally {
                errorHandlingNoResult(ps,conn);
        }


    }
    public List<Car> findAllCars() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Car> list = new ArrayList<>();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM cars;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

                list.add((Car) createVehicle(rs));
            }
        } catch (SQLException e) {
            throw new DaoException("findAllCars() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return list;

    }
    public Car findCarById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Car v = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM cars where vehicle_id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()){
                v = createVehicle(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("findCarById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return v;
    }
    public void deleteById(int id) throws DaoException
    {
        MySqlDao dao = new MySqlDao();
        dao.deleteById("cars","vehicle_id",id);
    }

    public Car createVehicle(ResultSet rs) throws SQLException {
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
        int numDoors = rs.getInt("number_doors");
        return new Car(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,numDoors);
    }
}
