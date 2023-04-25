package DAOs;

import DTOs.Car;
import DTOs.Dealer;
import DTOs.Vehicle;
import Exceptions.DaoException;

import java.util.List;

public interface VehicleDaoInterface {

    public void insertCar(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, int numDoors) throws DaoException;

    public List<Vehicle> findAllVehicles() throws DaoException;





}
