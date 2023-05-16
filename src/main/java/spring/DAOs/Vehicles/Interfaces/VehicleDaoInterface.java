package spring.DAOs.Vehicles.Interfaces;

import spring.DTOs.Vehicle;
import spring.Exceptions.DaoException;

import java.util.List;

public interface VehicleDaoInterface {


    public List<Vehicle> findAllVehicles() throws DaoException;

    public Vehicle insertVehicle(Vehicle v) throws DaoException;

    public Vehicle deleteVehicle(int id, String type) throws DaoException;

}
