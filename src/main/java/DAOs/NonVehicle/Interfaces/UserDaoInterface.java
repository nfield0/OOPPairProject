package DAOs.NonVehicle.Interfaces;

import DTOs.User;
import Exceptions.DaoException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserDaoInterface {

    public void insertUser(int id, String name, String email, String password, int admin) throws DaoException;
    public User insertUser(User u) throws DaoException;

    public List<User> findAllUsers() throws DaoException;
    public void deleteById(int id) throws DaoException;
    public User findUserById(int id) throws DaoException;







}
