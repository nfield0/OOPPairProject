package spring.DTOs;

public class Plane extends Vehicle {
    private int numEngines;
    private int range;
    private int max_speed_knots;
    private int seating_capacity;

    public Plane(int id, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numEngines, int range, int max_speed_knots, int seating_capacity) {
        super(id, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer, imgUrl);
        this.setType("Airplane");
        this.numEngines = numEngines;
        this.range = range;
        this.max_speed_knots = max_speed_knots;
        this.seating_capacity = seating_capacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMax_speed_knots() {
        return max_speed_knots;
    }

    public void setMax_speed_knots(int max_speed_knots) {
        this.max_speed_knots = max_speed_knots;
    }

    public int getSeating_capacity() {
        return seating_capacity;
    }

    public void setSeating_capacity(int seating_capacity) {
        this.seating_capacity = seating_capacity;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numEngines=" + numEngines +
                ", range=" + range +
                ", max_speed_knots=" + max_speed_knots +
                ", seating_capacity=" + seating_capacity +
                '}';
    }
}
