package spring.DAOs.Vehicles.Interfaces;

import spring.DTOs.Car;
import spring.DTOs.Dealer;
import spring.Exceptions.DaoException;

import java.util.List;

public interface CarDaoInterface {

    public void insertCar(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numDoors) throws DaoException;

    public void insertCar(Car c) throws DaoException;
    public void updateCar(int id,String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numDoors) throws DaoException;

    public List<Car> findAllCars() throws DaoException;
    public Car findCarById(int id) throws DaoException;
    public void deleteById(int id) throws DaoException;





}
