package DTOs;

public class Car extends Vehicle {

private int wheels;
private int numDoors;


    public Car(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int wheels, int numDoors) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.wheels = wheels;
        this.numDoors = numDoors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", numDoors=" + numDoors +
                '}' + super.toString();
    }
}
