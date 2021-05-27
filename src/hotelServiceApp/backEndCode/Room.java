package hotelServiceApp.backEndCode;

import java.util.ArrayList;
import java.util.List;

public final class Room {

    private int roomNumber;
    private int maxCapacity;
    private Occupation occupation;
    private List<Booking> bookingList;
    private boolean available;

    public Room() {

        this.bookingList=new ArrayList<Booking>();
        this.available=true;
    }

    public Room(int roomNumber, int maxCapacity) {

        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.bookingList = new ArrayList<Booking>();
        this.available = true;
    }

    public int getRoomNumber() {

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

    public boolean isAvailable() {

        return available;
    }

    public void setAvailable(boolean available) {

        this.available = available;
    }
}
