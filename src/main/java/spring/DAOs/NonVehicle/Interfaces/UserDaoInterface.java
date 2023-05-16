package spring.DAOs.NonVehicle.Interfaces;

import org.springframework.stereotype.Service;
import spring.DTOs.User;
import spring.Exceptions.DaoException;

import java.util.List;


@Service
public interface UserDaoInterface {

    public void insertUser(int id, String name, String email, String password, int admin) throws DaoException;
    public User insertUser(User u) throws DaoException;

    public List<User> findAllUsers() throws DaoException;
    public User deleteById(int id) throws DaoException;
    public User findUserById(int id) throws DaoException;







}
