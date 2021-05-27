package hotelServiceApp.backEndCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Room {

    private int roomNumber;
    private int maxCapacity;
    private Integer bedroomsAmount;
    private Occupation occupation;
    private List<Booking> bookingList;
    private List<Passenger> passengers;
    private double price;
    private boolean available;

    public Room() {

        this.bookingList = new ArrayList<Booking>();
        this.available = true;
    }

    public Room(int roomNumber, int maxCapacity, int bedroomsAmount, double price) {

        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.bedroomsAmount = bedroomsAmount;
        this.bookingList = new ArrayList<Booking>();
        this.available = true;
        this.price = price;
    }

    public Integer getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {

        this.roomNumber = roomNumber;
    }

    public int getMaxCapacity() {

        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {

        this.maxCapacity = maxCapacity;
    }

    public Integer getBedroomsAmount() {
        return bedroomsAmount;
    }

    public void setBedroomsAmount(Integer bedroomsAmount) {
        this.bedroomsAmount = bedroomsAmount;
    }

    public Occupation getOccupation() {

        return occupation;
    }

    public void setOccupation(Occupation occupation) {

        this.occupation = occupation;
    }

    public List<Booking> getBookingList() {

        return bookingList;
    }

    public void setBookingList(Booking booking) {

        this.bookingList.add(booking);
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public boolean isAvailable() {

        return available;
    }

    public void setAvailable(boolean available) {

        this.available = available;
    }

    public Boolean isRoomAvailable(LocalDate firstDate, LocalDate secondDate){

        Boolean confirm = false;
        for (Booking booking : this.bookingList){

            if (booking.isBookingAvailable(firstDate,secondDate).equals(true)){

                confirm=true;
            }
        }
        return confirm;
    }

    public void deleteBooking(Booking booking){

        int index=0;
        for (Booking bookingFound : this.bookingList){

            if (bookingFound.equals(booking)){
                this.bookingList.set(index,null);
            }
            index++;
        }
    }
}
