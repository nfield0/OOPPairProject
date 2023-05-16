package spring.DAOs.Vehicles;

import spring.DAOs.MySqlDao;
import spring.DAOs.Vehicles.Interfaces.*;
import spring.DTOs.*;
import spring.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlVehicleDao extends MySqlDao implements VehicleDaoInterface {


    public List<Vehicle> findAllVehicles() throws DaoException
    {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            CarDaoInterface carDao = new MySqlCarDao();
            List<Car> cars= carDao.findAllCars();
            vehicles.addAll(cars);

            BoatDaoInterface boatDao = new MySqlBoatDao();
            List<Boat> boats = boatDao.findAllBoats();
            vehicles.addAll(boats);

            TruckDaoInterface truckDao = new MySqlTruckDao();
            List<Truck> trucks = truckDao.findAllTrucks();
            vehicles.addAll(trucks);

            PlaneDaoInterface planeDao = new MySqlPlaneDao();
            List<Plane> planes = planeDao.findAllPlanes();
            vehicles.addAll(planes);




        } catch (SQLException e) {
            throw new DaoException("findAllVehicles() " + e.getMessage());
        }

        return vehicles;
    }
    public Vehicle insertVehicle(Vehicle v) throws DaoException
    {
        if(v instanceof Car)
        {
            CarDaoInterface carDao = new MySqlCarDao();
            carDao.insertCar((Car) v);
        }
        else if (v instanceof Boat)
        {
            BoatDaoInterface boatDao = new MySqlBoatDao();
            boatDao.insertBoat((Boat) v);
        }
        else if (v instanceof Truck)
        {
            TruckDaoInterface truckDao = new MySqlTruckDao();
            truckDao.insertTruck((Truck) v);
        }
        else if (v instanceof Plane)
        {
            PlaneDaoInterface planeDao = new MySqlPlaneDao();
            planeDao.insertPlane((Plane) v);
        }


        return v;
    }

    public Vehicle deleteVehicle(int id, String type) throws DaoException
    {
        deleteById(type,"vehicle_id",id);
        return null;
    }

}
