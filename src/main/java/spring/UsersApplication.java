package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import spring.Exceptions.CorsConfiguration;

@SpringBootApplication
@Import(CorsConfiguration.class)
@ComponentScan(basePackages = {"spring.DAOs.NonVehicle.Interfaces","spring.controller"})
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
