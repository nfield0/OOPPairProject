package spring.DAOs.Vehicles.Interfaces;

import spring.DTOs.Boat;
import spring.DTOs.Dealer;
import spring.Exceptions.DaoException;

import java.util.List;

public interface BoatDaoInterface {

    public void insertBoat(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numberLifeBoats, int max_speed_knots) throws DaoException;

    public void insertBoat(Boat b) throws DaoException;

    public List<Boat> findAllBoats() throws DaoException;
    public Boat findBoatById(int id) throws DaoException;
    public void deleteById(int id) throws DaoException;





}
