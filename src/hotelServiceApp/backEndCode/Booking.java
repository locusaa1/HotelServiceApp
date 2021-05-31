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

    /**
     * public String getToString()
     * This method is shorter than toString and it is used to show the booking in the user interface.
     */
    public String getToString() {
        return "Booking: " + "\n" +
                "Done in: " + this.date + "\n" +
                "Room: " + this.getRoom().getRoomNumber() + "\n" +
                "From: " + this.checkin + " till " + this.checkout;
    }

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString() {
        return "Booking{" + "\n" +
                "Booking Date: " + this.date + "\n" +
                "Passanger Info { " + "\n" +
                this.passenger.toString() + "\n" +
                "Room: " + this.room + "\n" +
                "Check-in Date: " + this.checkin + "\n" +
                "Check-out Date: " + this.checkout;
    }

    /**
     * public Boolean isBookingAvailable(LocalDate firstDate, LocalDate secondDate)
     * This method return a Boolean as a confirmation if the two localDates passed by parameters aren't inside the dates of a booking.
     */
    public Boolean isBookingAvailable(LocalDate firstDate, LocalDate secondDate) {

        Boolean confirm = false;
        if (firstDate.isBefore(this.checkin) && secondDate.isBefore(this.checkin)) {

            confirm = true;
        } else if (firstDate.isAfter(this.checkout) && secondDate.isAfter(this.checkout)) {

            confirm = true;
        }
        return confirm;
    }
}
