package DAOs.Vehicles;

import DTOs.Vehicle;
import Exceptions.DaoException;

import java.util.List;

public interface VehicleDaoInterface {


    public List<Vehicle> findAllVehicles() throws DaoException;





}
