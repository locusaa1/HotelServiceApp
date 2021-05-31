package hotelServiceApp.backEndCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Passenger extends Person {

    private UUID id;
    private Room room;
    private List<Purchase> purchases;
    private List<PassengerReview> passengerReviews;
    private Booking booking;
    private Boolean hosted;

    public Passenger() {

        super();
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
        this.passengerReviews = new ArrayList<>();
        this.booking = null;
        this.hosted = false;
    }

    public Passenger(String name, String surname, String dni, String country, String address, String phone, String username, String password) {

        super(name, username, dni, country, address, phone, username, password);
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
        this.passengerReviews = new ArrayList<>();
        this.booking = null;
        this.hosted = false;
    }

    public Room getRoom() {

        return room;
    }

    public void setRoom(Room room) {

        this.room = room;
    }

    public List<Purchase> getPurchases() {

        return purchases;
    }

    public void setPurchases(Purchase purchase) {

        this.purchases.add(purchase);
    }

    public List<PassengerReview> getPassengerReviews() {

        return passengerReviews;
    }

    public void setPassengerReviews(PassengerReview passengerReview) {

        this.passengerReviews.add(passengerReview);
    }

    public Booking getBooking() {

        return booking;
    }

    public void setBooking(Booking booking) {

        this.booking = new Booking();
        this.booking = booking;
    }

    public Boolean getHosted() {

        return hosted;
    }

    public void setHosted(Boolean hosted) {

        this.hosted = hosted;
    }

    /**
     * public double totalPurchases()
     * This method returns the total amount of all the purchases of a passenger
     */
    public double totalPurchases() {
        double total = 0;
        for (Purchase purchase : purchases) {
            total += purchase.totalPrice();
        }
        return total;
    }

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString() {
        return "Passenger" + "\n" +
                super.toString();
    }
}
