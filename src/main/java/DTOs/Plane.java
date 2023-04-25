package DTOs;

public class Plane extends Vehicle {
    private int numEngines;

    public Plane(int id, String type, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, int numEngines) {
        super(id, type, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer);
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
