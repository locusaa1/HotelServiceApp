package hotelServiceApp.backEndCode;

import java.time.LocalDate;
import java.util.UUID;

public final class Booking {

    private UUID id;
    private LocalDate date;
    private Passenger passenger;
    private Room room;
    private LocalDate checkin;
    private LocalDate checkout;

    public Booking() {

        this.id = UUID.randomUUID();
    }

    public Booking(LocalDate date, Passenger passenger, Room room, LocalDate checkin, LocalDate checkout) {

        this.id = UUID.randomUUID();
        this.date = date;
        this.passenger = passenger;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public Passenger getPassenger() {

        return passenger;
    }

    public void setPassenger(Passenger passenger) {

        this.passenger = passenger;
    }

    public Room getRoom() {

        return room;
    }

    public void setRoom(Room room) {

        this.room = room;
    }

    public LocalDate getCheckin() {

        return checkin;
    }

    public void setCheckin(LocalDate checkin) {

        this.checkin = checkin;
    }

    public LocalDate getCheckout() {

        return checkout;
    }

    public void setCheckout(LocalDate checkout) {

        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Booking: " + "\n" +
                "Done in: " + this.date + "\n" +
                "Room: " + this.getRoom().getRoomNumber() + "\n"+
                "From: " + this.checkin + " till " + this.checkout;
    }
}
