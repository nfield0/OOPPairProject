package spring.DAOs.Vehicles.Interfaces;

import spring.DTOs.Dealer;
import spring.DTOs.Truck;
import spring.DTOs.Vehicle;
import spring.Exceptions.DaoException;

import java.util.List;

public interface TruckDaoInterface {

    public void insertTruck(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int weight_capacity) throws DaoException;
    public void insertTruck(Truck t) throws DaoException;

    public List<Truck> findAllTrucks() throws DaoException;

    public void deleteById(int id) throws DaoException;


    public Truck findTruckById(int id) throws DaoException;
}
