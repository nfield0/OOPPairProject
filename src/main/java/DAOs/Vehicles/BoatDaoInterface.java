package DAOs.Vehicles;

import DTOs.Boat;
import DTOs.Car;
import DTOs.Dealer;
import Exceptions.DaoException;

import java.util.List;

public interface BoatDaoInterface {

    public void insertBoat(String type, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numberLifeBoats, int max_speed_knots) throws DaoException;

    public List<Boat> findAllBoats() throws DaoException;





}
