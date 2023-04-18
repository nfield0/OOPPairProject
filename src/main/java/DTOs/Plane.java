package DTOs;

public class Plane extends Vehicle {
    private int numEngines;
    public Plane(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int numEngines) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.numEngines = numEngines;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "numEngines=" + numEngines +
                '}' + super.toString();
    }
}
