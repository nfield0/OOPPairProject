package DAOs.Vehicles.Interfaces;

import DTOs.Dealer;
import DTOs.Truck;
import Exceptions.DaoException;

import java.util.List;

public interface TruckDaoInterface {

    public void insertTruck(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int weight_capacity) throws DaoException;

    public List<Truck> findAllTrucks() throws DaoException;

    public void deleteById(int id) throws DaoException;




}
