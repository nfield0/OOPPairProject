package spring.DTOs;

public class Boat extends Vehicle {
    private int numLifeBoats;
    private int max_speed_knots;

    public Boat() {
    }

    public Boat(String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl, int numLifeBoats, int max_speed_knots) {
        super(make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer,imgUrl);
        this.setType("Boat");
        this.numLifeBoats = numLifeBoats;
        this.max_speed_knots = max_speed_knots;
    }
    public Boat(int id, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numLifeBoats,int max_speed_knots) {
        super(id, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer,imgUrl);
        this.setType("Boat");
        this.numLifeBoats = numLifeBoats;
        this.max_speed_knots = max_speed_knots;
    }

    public int getNumLifeBoats() {
        return numLifeBoats;
    }

    public void setNumLifeBoats(int numLifeBoats) {
        this.numLifeBoats = numLifeBoats;
    }

    public int getMax_speed_knots() {
        return max_speed_knots;
    }

    public void setMax_speed_knots(int max_speed_knots) {
        this.max_speed_knots = max_speed_knots;
    }
    @Override
    public void displayBasicInfo()
    {
        System.out.println("Boat: " + getMake() + " " + getModel());
    }
    @Override
    public String toString() {
        return super.toString() +
                ", numLifeBoats=" + numLifeBoats +
                ", max_speed_knots=" + max_speed_knots +
                '}';
    }
}
