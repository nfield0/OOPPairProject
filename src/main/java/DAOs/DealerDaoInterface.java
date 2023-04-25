package DAOs;

import DTOs.Dealer;
import Exceptions.DaoException;

import java.util.List;

public interface DealerDaoInterface {

    public void insertDealer(String name, String address, String phone_num) throws DaoException;

    public List<Dealer> findAllDealers() throws DaoException;
    public Dealer findDealerById(int id) throws DaoException;






}
