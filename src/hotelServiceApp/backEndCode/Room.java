package hotelServiceApp.backEndCode;

import java.util.List;

public final class Room {
    private int roomNumber;
    private int maxCapacity;
    private List<Passenger> passengers;
    private boolean available;

    public Room() {
    }

    public Room(int roomNumber, int maxCapacity, List<Passenger> passengers, boolean available) {
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.passengers = passengers;
        this.available = available;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
