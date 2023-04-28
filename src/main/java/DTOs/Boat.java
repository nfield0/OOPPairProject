package DTOs;

public class Boat extends Vehicle {
    private int numSails;

    public Boat(int id, String type, String make, String model, String engine, String registration, String color, int weightInTonnes, int numPassengers, int mileage, int price, String fuelType, Dealer dealer, String imgUrl,int numSails) {
        super(id, type, make, model, engine, registration, color, weightInTonnes, numPassengers, mileage, price, fuelType, dealer,imgUrl);
        this.numSails = numSails;
    }

    public int getNumSails() {
        return numSails;
    }

    public void setNumSails(int numSails) {
        this.numSails = numSails;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "numSails=" + numSails +
                '}' + super.toString();
    }
}
