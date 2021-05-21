package hotelServiceApp.backEndCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Purchase {

    private UUID id;
    private LocalDate purchaseDate;
    private Room room;
    private Passenger passenger;
    private List<SupplyItem> supplyItems;
    private double totalPrice;

    public Purchase() {

        this.id=UUID.randomUUID();
        this.supplyItems = new ArrayList<>();
    }

    public Purchase(LocalDate purchaseDate, Room room, Passenger passenger, List<SupplyItem> supplyItems, double totalPrice) {

        this.id=UUID.randomUUID();
        this.purchaseDate=purchaseDate;
        this.room=room;
        this.passenger=passenger;
        this.supplyItems=supplyItems;
        this.totalPrice=totalPrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public List<SupplyItem> getSupplyItems() {
        return supplyItems;
    }

    public void setSupplyItems(List<SupplyItem> supplyItems) {
        this.supplyItems = supplyItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
