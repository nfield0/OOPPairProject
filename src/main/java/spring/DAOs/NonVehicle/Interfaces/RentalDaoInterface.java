package spring.DAOs.NonVehicle.Interfaces;

import spring.DTOs.VehicleRental;
import spring.Exceptions.DaoException;

import java.util.List;

public interface RentalDaoInterface {

    public void insertRental() throws DaoException;

    public List<VehicleRental> findAllRentals() throws DaoException;
    public VehicleRental findRentalById(int id) throws DaoException;

    public void deleteById(int id) throws DaoException;





}
