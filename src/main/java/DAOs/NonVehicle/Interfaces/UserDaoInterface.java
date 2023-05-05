package DAOs.NonVehicle.Interfaces;

import DTOs.User;
import Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface {

    public void insertUser(int id, String name, String email, String password, int admin) throws DaoException;

    public List<User> findAllUsers() throws DaoException;
    public void deleteById(int id) throws DaoException;
    public User findUserById(int id) throws DaoException;







}
