package spring.DAOs.Vehicles;

import spring.DAOs.MySqlDao;
import spring.DAOs.Vehicles.Interfaces.*;
import spring.DTOs.*;
import spring.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlVehicleDao extends MySqlDao implements VehicleDaoInterface {

    CarDaoInterface carDao = new MySqlCarDao();
    BoatDaoInterface boatDao = new MySqlBoatDao();
    TruckDaoInterface truckDao = new MySqlTruckDao();
    PlaneDaoInterface planeDao = new MySqlPlaneDao();
    public List<Vehicle> findAllVehicles() throws DaoException
    {
        List<Vehicle> vehicles = new ArrayList<>();

        try {
            List<Car> cars= carDao.findAllCars();
            vehicles.addAll(cars);
            List<Boat> boats = boatDao.findAllBoats();
            vehicles.addAll(boats);
            List<Truck> trucks = truckDao.findAllTrucks();
            vehicles.addAll(trucks);
            List<Plane> planes = planeDao.findAllPlanes();
            vehicles.addAll(planes);
        } catch (SQLException e) {
            throw new DaoException("findAllVehicles() " + e.getMessage());
        }

        return vehicles;
    }
    public Vehicle findVehicleById(int id) throws DaoException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = this.getConnection();

            String query = "SELECT * FROM vehicles where vehicle_id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()){

                if(rs.getString(1).equalsIgnoreCase("Boat"))
                {
                    query = "SELECT * FROM boats where vehicle_id = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        return boatDao.findBoatById(id);
                    }
                }
                else if(rs.getString(1).equalsIgnoreCase("Car"))
                {
                    query = "SELECT * FROM cars where vehicle_id = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        return carDao.findCarById(id);
                    }
                }
                else if(rs.getString(1).equalsIgnoreCase("Truck"))
                {
                    query = "SELECT * FROM trucks where vehicle_id = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        return truckDao.findTruckById(id);
                    }
                }
                else if(rs.getString(1).equalsIgnoreCase("Airplane"))
                {
                    query = "SELECT * FROM airplanes where vehicle_id = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        return planeDao.findPlaneById(id);
                    }
                }

            }
        } catch (SQLException e) {
            throw new DaoException("findVehicleById() " + e.getMessage());
        } finally {
            errorHandling(rs,ps,conn);
        }
        return null;
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
