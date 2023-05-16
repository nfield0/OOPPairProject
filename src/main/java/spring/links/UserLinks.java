package spring.links;

import org.springframework.stereotype.Component;

@Component
public class UserLinks {
	
	public static final String LIST_USERS = "/users";
	public static final String FIND_USER_BY_ID = "/user/:id";
    public static final String ADD_USER = "/user";
    public static final String DELETE_USER = "/user/:id";



    public static final String LIST_VEHICLES = "/vehicles";
    public static final String ADD_VEHICLE = "/vehicle";
    public static final String FIND_VEHICLE_BY_ID = "/vehicle/:id";
    public static final String DELETE_VEHICLE = "/vehicle/:id";

}
