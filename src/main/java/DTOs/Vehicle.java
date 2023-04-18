package DTOs;

import java.util.List;

public abstract class Vehicle {
    private int id;
    private String make;
    private String model;
    private String engine;
    private String registration;
    private String color;
    private int weightInTonnes;
    private int numPassengers;
    private int mileage;
    private int price;
    private String fuelType;
    // composition (has dealer)
    private Dealer dealer;

    public Vehicle(int id, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.registration = registration;
        this.color = color;
        this.weightInTonnes = weightInTonnes;
        this.numPassengers = numPassengers;
        this.mileage = mileage;
        this.price = price;
        this.fuelType = fuelType;
        this.dealer = dealer;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeightInTonnes() {
        return weightInTonnes;
    }

    public void setWeightInTonnes(int weightInTonnes) {
        this.weightInTonnes = weightInTonnes;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", registration='" + registration + '\'' +
                ", color='" + color + '\'' +
                ", weightInTonnes=" + weightInTonnes +
                ", numPassengers=" + numPassengers +
                ", mileage=" + mileage +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                ", dealer=" + dealer +
                '}';
    }
}
