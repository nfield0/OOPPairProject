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

        //Users
        //insertUser(0,"John","john@gmail.com","Password1",0);
        findAllUsers();


        //Dealers
        //insertDealer("Mercedes Dundalk","Dundalk, Co.Louth","087-7741222");
        findAllDealers();


        //Cars
        CarDaoInterface carDao = new MySqlCarDao();
        Car c = new Car(0,"Volkswagen","Golf","1.6L tdi", "124lk00","White",2.5,5,10000,10000,"Diesel",dealer,"",5 );
        //insertCar(c);
        findAllCars();
        System.out.println("Find one");
        findCarById(1);
        carDao.deleteById(1);

        //Boats
        Boat b = new Boat(0,"Bayliner", "2455 Ciera", "MerCruiser 5.7L", "FL2345", "White", 2.5, 6, 450, 30000, "Gasoline", dealer, "", 1, 30);
        //insertBoat(b);
        findAllBoats();


        //Trucks
        Truck t = new Truck(0,"Volvo", "VNL 760", "Volvo D13TC", "TX1234", "Blue", 18.1, 2, 500000, 120000, "Diesel", dealer, "", 80000);
        //insertTruck(t);
        findAllTrucks();


        //Planes

        Plane p = new Plane(0,"Boeing", "737 MAX", "CFM International", "N12345", "White", 79.0, 189, 4850, 120000000, "Jet A", dealer, "", 2, 3700, 470, 220);
        //insertPlane(p);
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

    private static void insertCar(Car c)
    {
        CarDaoInterface carDao = new MySqlCarDao();
        try
        {
            carDao.insertCar(c.getMake(),c.getModel(),c.getEngine(),c.getRegistration(),c.getColor(),c.getWeightInTonnes(),c.getNumPassengers(),c.getMileage(),c.getPrice(),c.getFuelType(),c.getDealer(),c.getImgUrl(),c.getNumDoors());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void insertTruck(Truck v)
    {
        TruckDaoInterface dao = new MySqlTruckDao();
        try
        {
            dao.insertTruck(v.getMake(),v.getModel(),v.getEngine(),v.getRegistration(),v.getColor(),v.getWeightInTonnes(),v.getNumPassengers(),v.getMileage(),v.getPrice(),v.getFuelType(),v.getDealer(),v.getImgUrl(),v.getWeight_capacity());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void insertBoat(Boat v)
    {
        BoatDaoInterface dao = new MySqlBoatDao();
        try
        {
            dao.insertBoat(v.getMake(),v.getModel(),v.getEngine(),v.getRegistration(),v.getColor(),v.getWeightInTonnes(),v.getNumPassengers(),v.getMileage(),v.getPrice(),v.getFuelType(),v.getDealer(),v.getImgUrl(),v.getNumLifeBoats(),v.getMax_speed_knots());
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
    private static void insertPlane(Plane v)
    {
        PlaneDaoInterface dao = new MySqlPlaneDao();
        try
        {
            dao.insertPlane(v.getMake(),v.getModel(),v.getEngine(),v.getRegistration(),v.getColor(),v.getWeightInTonnes(),v.getNumPassengers(),v.getMileage(),v.getPrice(),v.getFuelType(),v.getDealer(),v.getImgUrl(),v.getNumEngines(),v.getRange(),v.getMax_speed_knots(),v.getSeating_capacity());
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