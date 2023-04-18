package DTOs;

public abstract class Vehicle {
    private int id;
    private static int nextId = 100;
    private String make;
    private String model;
    private String colour;
    private String registration;
    private int numPassengers;
    private double engineCapacity;

    public Vehicle(String make, String model, String colour, String registration, int numPassengers, double engineCapacity) {
        this.id = nextId++;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.registration = registration;
        this.numPassengers = numPassengers;
        this.engineCapacity = engineCapacity;
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName() +
                ", id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", registration='" + registration + '\'' +
                ", numPassengers=" + numPassengers +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
