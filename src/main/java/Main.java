import DAOs.MySqlDao;
import DAOs.MySqlUserDao;
import DTOs.*;
import Exceptions.DaoException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Running");

        Dealer dealer = new Dealer(0,"Mercedes Porto","Porto","083123123");
        Car c1 = new Car(0,"Mazda","Miata","2.1L","0023lm","Red",5,5,4000,3000,"Diesel",dealer,5);



        User u1 = new User(0,"Nathan","nathan@gmail.com","Password1",0);
        User u2 = new User(1,"Arthur","arthur@gmail.com","Password2",1);

        System.out.println("Vehicles");

        System.out.println(c1);



        System.out.println("Users");
        System.out.println(u1);
        System.out.println(u2);

        MySqlDao mySqlDao = new MySqlDao();
        mySqlDao.getConnection();

        MySqlUserDao mySqlUserDao = new MySqlUserDao();
        mySqlUserDao.insertUser(0,"John","john@gmail.com","Password1",0);






    }




}