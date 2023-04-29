import DAOs.*;
import DAOs.NonVehicle.MySqlDealerDao;
import DAOs.NonVehicle.MySqlUserDao;
import DAOs.Vehicles.*;
import DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import DAOs.NonVehicle.Interfaces.UserDaoInterface;
import DAOs.Vehicles.Interfaces.BoatDaoInterface;
import DAOs.Vehicles.Interfaces.CarDaoInterface;
import DAOs.Vehicles.Interfaces.PlaneDaoInterface;
import DAOs.Vehicles.Interfaces.TruckDaoInterface;
import DTOs.*;
import Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Running");

        MySqlDao mySqlDao = new MySqlDao();
        mySqlDao.getConnection();

        Dealer dealer = new Dealer(1,"Mercedes","Gaia","048104");

        //insertUser(0,"John","john@gmail.com","Password1",0);
        findAllUsers();
        //insertDealer("Mercedes Dundalk","Dundalk, Co.Louth","087-7741222");
        findAllDealers();
        // insertCar("Hatchback","Volkswagen","Golf","1.6L tdi", "124lk00","White",2.5,5,10000,10000,"Diesel",dealer,"",5);
        findAllCars();
        System.out.println("Find one");
        findCarById(1);

        findAllBoats();


        findAllTrucks();

        findAllPlanes();



    }

    private static void findCarById(int id) throws DaoException {
        CarDaoInterface carDao = new MySqlCarDao();
        System.out.println(carDao.findCarById(id));
    }

    private static void findAllTrucks() {
        TruckDaoInterface dao = new MySqlTruckDao();
        try
        {
            List<Truck> list = dao.findAllTrucks();
            printVehicles(list, "Trucks");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void findAllPlanes() {
        PlaneDaoInterface dao = new MySqlPlaneDao();
        try
        {
            List<Plane> list = dao.findAllPlanes();
            printVehicles(list, "Planes");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findAllDealers() {
        DealerDaoInterface dealerDao = new MySqlDealerDao();
        try
        {
            List<Dealer> dealers = dealerDao.findAllDealers();
            printVehicles(dealers, "Dealers");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void insertDealer(String name, String address, String phone_num)
    {
        DealerDaoInterface dealerDao = new MySqlDealerDao();
        try
        {
            dealerDao.insertDealer(name,address,phone_num);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void insertCar(String type,String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numDoors)
    {
        CarDaoInterface carDao = new MySqlCarDao();
        try
        {
            carDao.insertCar(type,make,model,engine,registration,color,weightInTonnes,numPassengers,mileage,price,fuelType,dealer,imgUrl, numDoors);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }


    private static void findAllUsers() {

        UserDaoInterface userDao = new MySqlUserDao();
        try
        {
            List<User> users = userDao.findAllUsers();
            printVehicles(users, "Users");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void findAllCars() {
        CarDaoInterface carDao = new MySqlCarDao();
        try
        {
            List<Car> cars = carDao.findAllCars();
            printVehicles(cars,"Cars");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
    private static void findAllBoats() {
        BoatDaoInterface boatDao = new MySqlBoatDao();
        try
        {
            List<Boat> boats = boatDao.findAllBoats();
            printVehicles(boats,"Boats");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
    public static <T> void printVehicles(List<T> list,String type)
    {

        if(list.isEmpty())
        {
            System.out.println("No " + type + " found");
        }
        else
        {
            for(T i : list)
            {
                System.out.println(i);
            }

        }
    }


}