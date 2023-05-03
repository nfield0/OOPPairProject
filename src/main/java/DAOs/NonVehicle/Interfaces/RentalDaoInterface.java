package DAOs.NonVehicle.Interfaces;

import DTOs.Dealer;
import DTOs.VehicleRental;
import Exceptions.DaoException;

import java.util.List;

public interface RentalDaoInterface {

    public void insertRental() throws DaoException;

    public List<VehicleRental> findAllRentals() throws DaoException;
    public VehicleRental findRentalById(int id) throws DaoException;

    public void deleteById(int id) throws DaoException;





}
