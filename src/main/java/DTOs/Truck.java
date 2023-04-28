package DTOs;

public class Truck extends Vehicle{

    private int weight_capacity;

    public Truck(int id, String type, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl, int weight_capacity) {
        super(id, type, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer, imgUrl);
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
