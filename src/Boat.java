public class Boat extends Vehicle {
    private int numSails;
    public Boat(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int numSails) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.numSails = numSails;
    }
}
