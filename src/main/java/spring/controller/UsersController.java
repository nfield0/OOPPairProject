package spring.controller;

import org.springframework.stereotype.Repository;
import spring.DAOs.NonVehicle.MySqlUserDao;
import spring.DTOs.User;
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
public class UsersController {

	UserDaoInterface userDaoInterface = new MySqlUserDao();
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() throws DaoException {
        log.info("UsersController:  list users");
        List<User> resource = userDaoInterface.findAllUsers();
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_USER_BY_ID)
    public ResponseEntity<?> findUserByIdPost(@PathVariable int id) throws DaoException {
        log.info("UsersController: find user by ID using POST");
        User resource = userDaoInterface.findUserById(id);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.FIND_USER_BY_EMAIl_AND_PASSWORD)
    public ResponseEntity<?> findUserByEmailPassword(@PathVariable String email,@PathVariable String password) throws DaoException {
        log.info("UsersController:  find user by email, password");

        User resource = userDaoInterface.findUserByEmailAndPassword(email, password);
        if (resource != null) {
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping(path = UserLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@PathVariable String name,@PathVariable String email,@PathVariable String password) throws DaoException {
        log.info("UsersController:  insert user");
        User resource = userDaoInterface.insertUser(name,email,password);
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.DELETE_USER)
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws DaoException {
        log.info("UsersController:  insert user");
        User resource = userDaoInterface.deleteUserById(id);
        return ResponseEntity.ok(resource);
    }



}
