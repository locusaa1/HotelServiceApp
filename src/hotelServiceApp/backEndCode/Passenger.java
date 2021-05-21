package hotelServiceApp.backEndCode;

import java.util.List;
import java.util.UUID;

public final class Passenger extends Person{

    private UUID id;
    private Room room;
    private List<Purchase> purchases;
    private double occupationPrice;
    private double purchasesTotal;
    private List<PassengerReview> passengerReviews;


}
