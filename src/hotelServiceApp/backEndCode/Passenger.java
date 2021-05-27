package hotelServiceApp.backEndCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Passenger extends Person {

    private UUID id;
    private Room room;
    private List<Purchase> purchases;
    private List<PassengerReview> passengerReviews;
    private Boolean hosted;

    public Passenger() {

        super();
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
        this.passengerReviews = new ArrayList<>();
        this.hosted = false;
    }

    public Passenger(String name, String surname, String dni, String country, String address, String phone, String username, String password) {

        super(name, username, dni, country, address, phone, username, password);
        this.id = UUID.randomUUID();
        this.purchases = new ArrayList<>();
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

    public List<PassengerReview> getPassengerReviews() {

        return passengerReviews;
    }

    public void setPassengerReviews(PassengerReview passengerReview) {

        this.passengerReviews.add(passengerReview);
    }

    public Boolean getHosted() {

        return hosted;
    }

    public void setHosted(Boolean hosted) {

        this.hosted = hosted;
    }

    public double totalPurchases(){
        double total = 0;
        for(Purchase purchase : purchases){
            total += purchase.totalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Passenger" + "\n" +
                super.toString();
    }
}
