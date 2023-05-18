package spring.controller;

import org.springframework.stereotype.Repository;
import spring.DAOs.NonVehicle.Interfaces.DealerDaoInterface;
import spring.DAOs.NonVehicle.Interfaces.RentalDaoInterface;
import spring.DAOs.NonVehicle.MySqlDealerDao;
import spring.DAOs.NonVehicle.MySqlUserDao;
import spring.DAOs.NonVehicle.RentalDao;
import spring.DAOs.Vehicles.Interfaces.VehicleDaoInterface;
import spring.DAOs.Vehicles.MySqlVehicleDao;
import spring.DTOs.Dealer;
import spring.DTOs.User;
import spring.DTOs.Vehicle;
import spring.DTOs.VehicleRental;
import spring.Exceptions.DaoException;
import spring.links.UserLinks;
import spring.DAOs.NonVehicle.Interfaces.UserDaoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class VehicleController {

    VehicleDaoInterface daoInterface = new MySqlVehicleDao();
    RentalDaoInterface rDaoInterface = new RentalDao();
    DealerDaoInterface dDaoInterface = new MySqlDealerDao();
    @GetMapping(path = UserLinks.LIST_VEHICLES)
    public ResponseEntity<?> listVehicles() throws DaoException {
        log.info("VehiclesController:  list vehicles");
        List<Vehicle> resource = daoInterface.findAllVehicles();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = UserLinks.FIND_VEHICLE_BY_ID)
    public ResponseEntity<?> findOneVehicle(@PathVariable int id) throws DaoException {
        log.info("VehiclesController:  find one vehicle");
        Vehicle resource = daoInterface.findVehicleById(id);
        return ResponseEntity.ok(resource);
    }



    @PostMapping(path = UserLinks.ADD_VEHICLE)
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws DaoException {
        log.info("VehiclesController:  add vehicle");
        Vehicle resource = daoInterface.insertVehicle(vehicle);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.DELETE_VEHICLE)
    public ResponseEntity<?> deleteVehicle(@PathVariable int id,@PathVariable String type) throws DaoException {
        log.info("VehiclesController:  delete vehicle");
        Vehicle resource = daoInterface.deleteVehicle(id, type);
        return ResponseEntity.ok(resource);
    }
    @PostMapping(path = UserLinks.ADD_RENTAL)
    public ResponseEntity<?> addRental(@PathVariable int uid,@PathVariable int vid,@PathVariable int did,@PathVariable int duration) throws DaoException {
        log.info("VehiclesController:  add Rentals");
        VehicleRental resource = rDaoInterface.insertRental(uid,vid,did,duration);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_RENTALS_BY_VEHICLE_ID)
    public ResponseEntity<?> findRentalsByVehicleId(@PathVariable int id) throws DaoException {
        log.info("VehiclesController:  find Rentals vehicle");
        List<VehicleRental> resource = rDaoInterface.findRentalByVehicleId(id);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_RENTALS)
    public ResponseEntity<?> findRentals() throws DaoException {
        log.info("VehiclesController:  find RentalS");
        List<VehicleRental> resource = rDaoInterface.findAllRentals();
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_RENTALS_BY_USER_ID)
    public ResponseEntity<?> findRentalsByUserId(@PathVariable int id) throws DaoException {
        log.info("VehiclesController:  find Rentals vehicle");
        List<VehicleRental> resource = rDaoInterface.findRentalByUserId(id);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_DEALERS)
    public ResponseEntity<?> findDealers() throws DaoException {
        log.info("VehiclesController:  find Dealers");
        List<Dealer> resource = dDaoInterface.findAllDealers();
        return ResponseEntity.ok(resource);
    }
}
