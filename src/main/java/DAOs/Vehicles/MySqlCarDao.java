package DAOs.Vehicles;

import DAOs.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.MySqlDealerDao;
import DAOs.Vehicles.CarDaoInterface;
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


            ps.setInt(14, numDoors);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertCar() " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                throw new DaoException("insertCar() " + e.getMessage());
            }
        }


    }
    public List<Car> findAllCars() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Car> cars = new ArrayList<>();
        DealerDaoInterface dealerDao = new MySqlDealerDao();

        try {
            conn = this.getConnection();

            String query = "SELECT vehicle_id,type,make,model,engine,registration,color,weight_tonnes,number_passengers,mileage,price,fuel_type,dealer_id,img_url,number_doors FROM cars;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

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
                Car c = new Car(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,imgUrl,numDoors);
                cars.add(c);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllCars() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return cars;

    }
}
