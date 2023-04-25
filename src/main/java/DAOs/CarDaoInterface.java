package DAOs;

import DTOs.Car;
import DTOs.Dealer;
import DTOs.Vehicle;
import Exceptions.DaoException;

import java.util.List;

public interface CarDaoInterface {

    public void insertCar(int id, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, int numDoors) throws DaoException;

    public List<Car> findAllCars() throws DaoException;





}
