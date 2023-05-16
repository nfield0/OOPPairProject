package spring.DAOs.NonVehicle.Interfaces;

import spring.DTOs.Dealer;
import spring.Exceptions.DaoException;

import java.util.List;

public interface DealerDaoInterface {

    public void insertDealer(String name, String address, String phone_num) throws DaoException;

    public List<Dealer> findAllDealers() throws DaoException;
    public Dealer findDealerById(int id) throws DaoException;

    public void deleteById(int id) throws DaoException;





}
