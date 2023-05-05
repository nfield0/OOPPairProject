package DTOs;

public class Car extends Vehicle {
private int numDoors;


    public Car(int id, String make, String model, String engine, String registration, String color, double weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer,String imgUrl, int numDoors) {
        super(id, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer,imgUrl);
        this.setType("Car");
        this.numDoors = numDoors;
    }



    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numDoors=" + numDoors +
                '}';
    }
}
