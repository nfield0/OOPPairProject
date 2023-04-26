package DAOs.Vehicles;

import DAOs.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.MySqlDealerDao;
import DAOs.Vehicles.VehicleDaoInterface;
import DTOs.Dealer;
import DTOs.Vehicle;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlVehicleDao extends MySqlDao implements VehicleDaoInterface {


    public List<Vehicle> findAllVehicles() throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Vehicle> vehicles = new ArrayList<>();
        DealerDaoInterface dealerDao = new MySqlDealerDao();

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM C";
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
                int dealer_id = rs.getInt("dealer");
                Dealer dealer = dealerDao.findDealerById(dealer_id);
                int numDoors = rs.getInt("numDoors");
//                Car c = new Car(id,type,make,model,engine,registration,color,weight,number_passengers,mileage,price,fuel_type,dealer,numDoors);
//                cars.add(c);
            }


        } catch (SQLException e) {
            throw new DaoException("findAllVehicles() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return vehicles;

    }
}
