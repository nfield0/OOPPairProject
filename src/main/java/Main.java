import spring.DAOs.*;
import spring.DAOs.NonVehicle.Interfaces.RentalDaoInterface;
import spring.DAOs.NonVehicle.MySqlDealerDao;
import spring.DAOs.NonVehicle.MySqlUserDao;
import spring.DAOs.NonVehicle.RentalDao;
import spring.DAOs.Vehicles.*;
import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.NonVehicle.Interfaces.UserDaoInterface;
import spring.DAOs.Vehicles.Interfaces.*;
import spring.DTOs.*;
import spring.Exceptions.CorsConfiguration;
import spring.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Dealer dealer = new Dealer(1,"Mercedes","Gaia","048104");




//  OOP Concepts
//TODO   Inheritance is where a class can inherit properties and methods from another class. E.g Car inherits from Vehicle


// TODO  Composition is another OOP concept where an object is composed of one
//  or more other objects. E.g Rental composed of Vehicle, Dealer


//TODO  Interfaces specifies a set of methods that a class must implement. E.g UserDaoInterface + UserDao



//TODO  An Abstract classes is a class that cannot be instantiated.

        //Vehicle v = new Vehicle();


//TODO  Polymorphism is the ability of objects to take on different forms or types.
        //MySqlVehicleDao.insertVehicle();


//TODO  Method overriding is where a subclass implements a different
//      version of a method already created in the superclass. E.g @Override toString()


//TODO  Method overloading is where multiple methods can have the same name but different parameters. E.g User Constructor


//TODO  Encapsulation is hiding the internal details of an object. E.g private fields


//TODO  Dynamic method lookup is where the method implementation is
// determined at runtime based on the actual type of the object

        Car c = new Car(0,"Volkswagen","Golf","1.6L tdi", "124lk00","White",2.5,5,10000,10000,"Diesel",dealer,"",5 );
        Boat b = new Boat(0,"Bayliner", "2455 Ciera", "MerCruiser 5.7L", "FL2345", "White", 2.5, 6, 450, 30000, "Gasoline", dealer, "", 1, 30);
        c.displayBasicInfo();
        b.displayBasicInfo();









/* TODO ChatGPT Uses:
For Database Structure we used ChatGPT to design the structure of the application based on the Vehicle class and its children.
For Some Complex queries we used ChatGPT to generate them
Here is an example of one we generated:

        START TRANSACTION;
        INSERT INTO vehicles (type) VALUES
        ('Car');
        INSERT INTO cars (vehicle_id, make, model, engine, registration, color, weight_tonnes, number_passengers, mileage, price, fuel_type, dealer_id, img_url,number_doors)
        VALUES (LAST_INSERT_ID(), 'Honda', 'Civic', '2.0L Inline 4', 'AB-1234-CD', 'Red', '1500kg', 5, 25000, 15000, 'Gasoline', 1,'default.jpg',5);
        COMMIT;

What is Java Spring?
The Spring Framework (Spring) is an open-source application framework that provides infrastructure support for
developing Java applications. One of the most popular Java Enterprise Edition (Java EE) frameworks, Spring helps
developers create high performing applications using plain old Java objects (POJOs).

When we started to use Java Spring we found an exception when posting from a different port. We had MySql on Port 8080, but
also Java Spring running on port 3000. To find a solution to this, we asked ChatGPT.
ChatGPT suggested to add a CorsException.

Another issue we solved with ChatGPT was structure.
@ComponentScan(basePackages = "com.example.myapp.controllers")



*/


























//        MySqlDao mySqlDao = new MySqlDao();
//        mySqlDao.getConnection();
//
//
//
//        //Users
//        //insertUser(0,"John","john@gmail.com","Password1",0);
//        findAllUsers();
//        findUserById(2);
//        findUserByEmailAndPassword("nathan@gmail.com","Password");
//        deleteUserById(2);
//        findUserByEmailAndPassword("nathan@gmail.com","Password");
//
//
//        //Dealers
//        Dealer dealer = new Dealer(1,"Mercedes","Gaia","048104");
//        //insertDealer("Mercedes Dundalk","Dundalk, Co.Louth","087-7741222");
//        findAllDealers();
//
//        //Vehicles
//        //Cannot be instantiated
//        //Vehicle v = new Vehicle();
//        findVehicleById(2);
//
//
//
//
//
//        //Cars
//        Car c = new Car(0,"Volkswagen","Golf","1.6L tdi", "124lk00","White",2.5,5,10000,10000,"Diesel",dealer,"",5 );
//        CarDaoInterface carDao = new MySqlCarDao();
//
//        //insertCar(c);
//        findAllCars();
//        System.out.println("Find one");
//        findCarById(1);
//        carDao.deleteById(1);
//
//        //Boats
//        Boat b = new Boat(0,"Bayliner", "2455 Ciera", "MerCruiser 5.7L", "FL2345", "White", 2.5, 6, 450, 30000, "Gasoline", dealer, "", 1, 30);
//        //insertBoat(b);
//        findAllBoats();
//
//
//        //Trucks
//        Truck t = new Truck(0,"Volvo", "VNL 760", "Volvo D13TC", "TX1234", "Blue", 18.1, 2, 500000, 120000, "Diesel", dealer, "", 80000);
//        //insertTruck(t);
//        findAllTrucks();
//        Truck t2 = new Truck(0,"Volvo", "VNL 760", "Volvo D13TC", "TX1234", "Blue", 18.1, 2, 500000, 120000, "Diesel", dealer, "", 80000);
//
//
//
//        //Planes
//        Plane p = new Plane(0,"Boeing", "737 MAX", "CFM International", "N12345", "White", 79.0, 189, 4850, 120000000, "Jet A", dealer, "", 2, 3700, 470, 220);
//        //insertPlane(p);
//        findAllPlanes();
//
//
//
//        //Rentals
//        findRentalByVehicleId(2);
//        findRentalByUserId(1);




    }



    private static void findCarById(int id) throws DaoException {
        CarDaoInterface carDao = new MySqlCarDao();
        System.out.println(carDao.findCarById(id));
    }
    private static void findVehicleById(int id) throws DaoException {
        VehicleDaoInterface vDao = new MySqlVehicleDao();
        System.out.println(vDao.findVehicleById(id));
    }
    private static void insertVehicle(Vehicle v) throws DaoException {
        VehicleDaoInterface vDao = new MySqlVehicleDao();
        System.out.println(vDao.insertVehicle(v));
    }
    private static void findUserById(int id) throws DaoException {
        UserDaoInterface uDao = new MySqlUserDao();
        System.out.println(uDao.findUserById(id));
    }
    private static void deleteUserById(int id) throws DaoException {
        UserDaoInterface uDao = new MySqlUserDao();
        System.out.println(uDao.deleteUserById(id));
    }
    private static void findUserByEmailAndPassword(String email, String password) throws DaoException {
        UserDaoInterface uDao = new MySqlUserDao();
        System.out.println(uDao.findUserByEmailAndPassword(email,password));
    }
    private static void findRentalByVehicleId(int id) throws DaoException {
        RentalDaoInterface uDao = new RentalDao();
        System.out.println(uDao.findRentalByVehicleId(id));
    }
    private static void findRentalByUserId(int id) throws DaoException {
        RentalDaoInterface uDao = new RentalDao();
        System.out.println(uDao.findRentalByUserId(id));
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