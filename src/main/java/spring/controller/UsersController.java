package spring.controller;

import DTOs.User;
import Exceptions.DaoException;
import spring.links.UserLinks;
import DAOs.NonVehicle.Interfaces.UserDaoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {
	
	@Autowired
	UserDaoInterface usersService;
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() throws DaoException {
        log.info("UsersController:  list users");
        List<User> resource = usersService.findAllUsers();
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = UserLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws DaoException {
        log.info("UsersController:  list users");
        User resource = usersService.insertUser(user);
        return ResponseEntity.ok(resource);
    }
}
