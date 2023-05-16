package spring.controller;

import org.springframework.stereotype.Repository;
import spring.DAOs.NonVehicle.MySqlUserDao;
import spring.DAOs.Vehicles.Interfaces.VehicleDaoInterface;
import spring.DAOs.Vehicles.MySqlVehicleDao;
import spring.DTOs.User;
import spring.DTOs.Vehicle;
import spring.Exceptions.DaoException;
import spring.links.UserLinks;
import spring.DAOs.NonVehicle.Interfaces.UserDaoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class VehicleController {

    VehicleDaoInterface daoInterface = new MySqlVehicleDao();
    @GetMapping(path = UserLinks.LIST_VEHICLES)
    public ResponseEntity<?> listVehicles() throws DaoException {
        log.info("VehiclesController:  list vehicles");
        List<Vehicle> resource = daoInterface.findAllVehicles();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = UserLinks.ADD_VEHICLE)
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws DaoException {
        log.info("VehiclesController:  add vehicle");
        Vehicle resource = daoInterface.insertVehicle(vehicle);
        return ResponseEntity.ok(resource);
    }
    @PostMapping(path = UserLinks.DELETE_VEHICLE)
    public ResponseEntity<?> deleteVehicle(@RequestBody Vehicle vehicle) throws DaoException {
        log.info("VehiclesController:  delete vehicle");
        Vehicle resource = daoInterface.deleteVehicle(vehicle.getId(), vehicle.getType());
        return ResponseEntity.ok(resource);
    }
}
