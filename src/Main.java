import DTOs.Boat;
import DTOs.Car;
import DTOs.Plane;
import DTOs.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running");


        Car c1 = new Car("Mazda","Miata","Red","0023lm",5,1.5,4,3);
        Boat b1 = new Boat("Douro","Tawny","Red","0012pt",15,1.5,2);
        Plane p1 = new Plane("Boeing","747","White","jdal12",200,3,4);

        User u1 = new User(0,"Nathan","nathan@gmail.com","Password1",0);
        User u2 = new User(1,"Arthur","arthur@gmail.com","Password2",1);

        System.out.println("Vehicles");

        System.out.println(c1);
        System.out.println(b1);
        System.out.println(p1);

        System.out.println("Users");
        System.out.println(u1);
        System.out.println(u2);




    }




}