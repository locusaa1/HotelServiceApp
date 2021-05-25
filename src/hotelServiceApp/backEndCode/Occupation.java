package hotelServiceApp.backEndCode;

import java.util.List;

public final class Occupation{
    private Booking booking;
    private List<Passenger> passengers;
    private double totalAmount;

    public Occupation() {
    }

    public Occupation(Booking booking, List<Passenger> passengers, double totalAmount) {
        this.booking = booking;
        this.passengers = passengers;
        this.totalAmount = totalAmount;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
