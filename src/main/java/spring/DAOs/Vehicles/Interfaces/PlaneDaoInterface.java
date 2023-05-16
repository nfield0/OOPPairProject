package spring.DAOs.Vehicles.Interfaces;

import spring.DTOs.Dealer;
import spring.DTOs.Plane;
import spring.Exceptions.DaoException;

import java.util.List;

public interface PlaneDaoInterface {

    public void insertPlane(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numEngines,int range, int max_speed_knots, int seating_capacity) throws DaoException;
    public void insertPlane(Plane p) throws DaoException;

    public List<Plane> findAllPlanes() throws DaoException;
    public void deleteById(int id) throws DaoException;





}
