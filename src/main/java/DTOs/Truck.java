package DTOs;

public class Truck extends Vehicle{

    private int weight_capacity;

    public Truck(String make, String model, String colour, String registration, int numPassengers, double engineCapacity, int weight_capacity) {
        super(make, model, colour, registration, numPassengers, engineCapacity);
        this.weight_capacity = weight_capacity;
    }

    public int getWeight_capacity() {
        return weight_capacity;
    }

    public void setWeight_capacity(int weight_capacity) {
        this.weight_capacity = weight_capacity;
    }

    @Override
    public String toString() {
        return "{" +
                "weight_capacity=" + weight_capacity +
                '}'
                + super.toString();
    }
}
