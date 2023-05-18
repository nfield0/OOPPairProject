package spring.links;

import org.springframework.stereotype.Component;

@Component
public class UserLinks {
	
	public static final String LIST_USERS = "/users";
	public static final String FIND_USER_BY_ID = "/user/{id}";
    public static final String FIND_USER_BY_EMAIl_AND_PASSWORD = "/user/{email}/{password}";
    public static final String ADD_USER = "/user/{name}/{email}/{password}";
    public static final String DELETE_USER = "/deluser/{id}";



    public static final String LIST_VEHICLES = "/vehicles";
    public static final String ADD_VEHICLE = "/vehicle";
    public static final String FIND_VEHICLE_BY_ID = "/vehicle/{id}";
    public static final String DELETE_VEHICLE = "/delVehicle/{id}/{type}";
    public static final String ADD_RENTAL = "/vehicleRentals/{uid}/{vid}/{did}/{duration}";
    public static final String FIND_RENTALS = "/vehicleRentals";
    public static final String FIND_RENTALS_BY_VEHICLE_ID = "/vehicleRentals/{id}";
    public static final String FIND_RENTALS_BY_USER_ID = "/userRentals/{id}";

}
