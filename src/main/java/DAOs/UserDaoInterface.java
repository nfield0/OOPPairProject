package DAOs;

import DTOs.User;
import Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface {

    public void insertUser(int id, String name, String email, String password, int admin) throws DaoException;

    public List<User> findAllUsers() throws DaoException;





}
