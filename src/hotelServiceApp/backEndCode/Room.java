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

        this.bookingList = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.available = true;
    }

    public Room(int roomNumber, int maxCapacity, int bedroomsAmount, double price) {

        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.bedroomsAmount = bedroomsAmount;
        this.bookingList = new ArrayList<>();
        this.passengers = new ArrayList<>();
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

    public List<Passenger> getPassengers() {

        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {

        this.passengers = passengers;
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

    /**
     * public Boolean isRoomAvailable(LocalDate firstDate, LocalDate secondDate)
     * This method compares every booking into the room with the dates in parameter to confirm if it is available.
     */
    public Boolean isRoomAvailable(LocalDate firstDate, LocalDate secondDate) {

        Boolean confirm = false;
        for (Booking booking : this.bookingList) {

            if (booking.isBookingAvailable(firstDate, secondDate).equals(true)) {

                confirm = true;
            }
        }
        if (this.bookingList.size() == 0) {

            confirm = true;
        }
        return confirm;
    }

    /**
     * public void deleteBooking(Booking booking)
     * This method deletes an existing booking searching if it is inside the list.
     * It could not be deleted inside the iteration because it will throw an Exception.
     */
    public void deleteBooking(Booking booking) {

        Boolean confirm = false;
        for (Booking bookingFound : this.bookingList) {

            if (bookingFound.equals(booking)) {

                confirm = true;
            }
        }
        if (confirm) {

            this.bookingList.remove(booking);
        }
    }

    /**
     * public double getTotalPurchases()
     * This method calculates the total amount of the purchases from all the passengers into the room and returns it.
     */
    public double getTotalPurchases() {

        double total = 0;
        for (Passenger p : this.passengers) {

            total += p.totalPurchases();
        }
        return total;
    }

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString() {
        return "Room details:" + "\n" +
                "room n°: " + this.roomNumber + "\n" +
                "Max capacity: " + this.maxCapacity + "\n" +
                "Bedrooms amount: " + this.bedroomsAmount + "\n" +
                "Price: " + this.price + "\n" +
                "Available: " + this.available;
    }
}
