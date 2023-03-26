

public class Car extends Vehicle{

private int wheels;
private int numDoors;


    public Car(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int wheels, int numDoors) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.wheels = wheels;
        this.numDoors = numDoors;
    }
}
