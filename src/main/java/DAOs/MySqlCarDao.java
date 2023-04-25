package DAOs;

import DAOs.DealerDaoInterface;
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

public class MySqlCarDao extends MySqlDao implements CarDaoInterface {

    public void insertCar(int id, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, int numDoors) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();

            String query = "INSERT INTO vehicles VALUES (null,?,?,?,?,?)";

//            ps = conn.prepareStatement(query);
//            ps.setInt(1, id);
//            ps.setString(2, name);
//            ps.setString(3, email);
//            ps.setString(4, password);
//            ps.setInt(5, admin);

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

            String query = "SELECT vehicles.vehicle_id,type,make,model,engine,registration,color,weight_tonnes,number_passengers,mileage,price,fuel_type,dealer_id,number_doors FROM vehicles,cars WHERE vehicles.vehicle_id = cars.vehicle_id;";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while(rs.next()){

                int id = rs.getInt("vehicles.vehicle_id");
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
                int numDoors = rs.getInt("number_doors");
                Car c = new Car(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,numDoors);
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
