public class Plane extends Vehicle {
    private int numEngines;
    public Plane(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int numEngines) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.numEngines = numEngines;
    }
}
