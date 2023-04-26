package DAOs.Vehicles;

import DTOs.Car;
import DTOs.Dealer;
import Exceptions.DaoException;

import java.util.List;

public interface CarDaoInterface {

    public void insertCar(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numDoors) throws DaoException;

    public List<Car> findAllCars() throws DaoException;





}
