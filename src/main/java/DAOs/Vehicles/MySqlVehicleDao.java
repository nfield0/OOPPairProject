package DAOs.Vehicles;

import DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import DAOs.MySqlDao;
import DAOs.NonVehicle.MySqlDealerDao;
import DAOs.Vehicles.Interfaces.VehicleDaoInterface;
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


//todo

        return vehicles;
    }
}
