package spring.DTOs;

import java.time.LocalDateTime;
import java.util.Date;

public class VehicleRental {
    private int rentalId;
    private User user;
    private Vehicle vehicle;
    private Dealer dealer;
    private Date startDate;
    private int durationInDays;
    private LocalDateTime createdDateTime;

    public VehicleRental(int rentalId, User user, Vehicle vehicle, Dealer dealer, Date startDate, int durationInDays, LocalDateTime createdDateTime) {
        this.rentalId = rentalId;
        this.user = user;
        this.vehicle = vehicle;
        this.dealer = dealer;
        this.startDate = startDate;
        this.durationInDays = durationInDays;
        this.createdDateTime = createdDateTime;
    }

    public VehicleRental(int rentalId, User user, Vehicle vehicle, Dealer dealer, Date startDate, int durationInDays) {
        this.rentalId = rentalId;
        this.user = user;
        this.vehicle = vehicle;
        this.dealer = dealer;
        this.startDate = startDate;
        this.durationInDays = durationInDays;
        this.createdDateTime = LocalDateTime.now();
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "VehicleRental{" +
                "rentalId=" + rentalId +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", dealer=" + dealer +
                ", startDate=" + startDate +
                ", durationInDays=" + durationInDays +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
