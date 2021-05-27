package hotelServiceApp.backEndCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Passenger extends Person {

    private UUID id;
    private Room room;
    private List<Purchase> purchases;
    private double occupationPrice;
    private double purchasesTotal;
    private List<PassengerReview> passengerReviews;
    private Booking booking;
    private Boolean hosted;

    public Passenger() {

        super();
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
        this.purchasesTotal = 0;
        this.passengerReviews = new ArrayList<>();
        this.hosted = false;
    }

    public Passenger(String name, String surname, String dni, String country, String address, String phone, String username, String password) {

        super(name, username, dni, country, address, phone, username, password);
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
        this.purchasesTotal = 0;
        this.passengerReviews = new ArrayList<>();
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

    public double getOccupationPrice() {

        return occupationPrice;
    }

    public void setOccupationPrice(double occupationPrice) {

        this.occupationPrice = occupationPrice;
    }

    public double getPurchasesTotal() {

        return purchasesTotal;
    }

    public void setPurchasesTotal(double purchasesTotal) {

        this.purchasesTotal = purchasesTotal;
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
        this.booking = booking;
    }

    public Boolean getHosted() {

        return hosted;
    }

    public void setHosted(Boolean hosted) {

        this.hosted = hosted;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name" + super.getName() +
                '}';
    }
}
