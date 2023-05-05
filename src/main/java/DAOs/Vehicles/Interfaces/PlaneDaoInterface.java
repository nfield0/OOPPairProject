package DAOs.Vehicles.Interfaces;

import DTOs.Dealer;
import DTOs.Plane;
import DTOs.Truck;
import Exceptions.DaoException;

import java.util.List;

public interface PlaneDaoInterface {

    public void insertPlane(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numEngines,int range, int max_speed_knots, int seating_capacity) throws DaoException;

    public List<Plane> findAllPlanes() throws DaoException;
    public void deleteById(int id) throws DaoException;





}
