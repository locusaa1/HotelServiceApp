package hotelServiceApp.backEndCode;

import com.sun.deploy.panel.ExceptionListDialog;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelData {

    private List<Passenger> passengerList;
    private List<Room> roomList;
    private List<Booking> bookingList;

    public HotelData() {

        this.passengerList = new ArrayList<>();
        this.roomList = new ArrayList<>();
        this.bookingList = new ArrayList<>();
    }

    public List<Passenger> getPassengerList() {

        return passengerList;
    }

    public void setPassengerList(Passenger passenger) {

        this.passengerList.add(passenger);
    }

    public Passenger getPassenger(int index) {

        return this.passengerList.get(index);
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(Room room) {
        this.roomList.add(room);
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(Booking booking) {
        this.bookingList.add(booking);
    }

    /**
     * public Boolean passengerExists(String dni)
     * This method searches in the passengerList of the HotelData if the dni in the parameter is already saved on a existing passenger.
     */

    public Boolean passengerExists(String dni) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getDni().equals(dni)) {
                confirm = true;
            }
        }
        return confirm;
    }

    /**
     * public Boolean usernameExists(String username)
     * This method searches in the PassengerList of the HotelData if the username is already taken.
     */

    public Boolean usernameExists(String username) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getUsername().equals(username)) {
                confirm = true;
            }
        }
        return confirm;
    }

    /**
     * public Passenger usernameSearchPassenger(String username)
     * This method searches in the PassengerList of the HotelData and return the passenger.
     * We assume that the passenger already exists. It needs to be checked first using the method passengerExists.
     */

    public Passenger usernameSearchPassenger(String username) {

        Passenger passenger = null;
        for (Passenger p : this.passengerList) {
            if (p.getUsername().equals(username)) {
                passenger = p;
            }
        }
        return passenger;
    }

    /**
     * public Boolean confirmPassword(String password, Passenger passenger)
     * This method confirms if the password parameter matches the passenger parameter password
     */

    public Boolean confirmPassword(String password, Passenger passenger) {

        Boolean confirm = false;
        if (passenger.getPassword().equals(password)) {
            confirm = true;
        }
        return confirm;
    }

    public Room searchAvailableRoom(LocalDate firstDate, LocalDate secondDate, int amountOfRooms) {

        Room roomFound = null;
        for (Room room : this.roomList) {

            if (room.getBedroomsAmount().equals(amountOfRooms) && room.isRoomAvailable(firstDate, secondDate).equals(true)) {

                roomFound = room;
            }
        }
        return roomFound;
    }

    public void setNewBooking(Passenger passenger, Room room, Booking booking) {

        passenger.setBooking(booking);
        room.setBookingList(booking);
        this.setBookingList(booking);
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

    public void deleteExistingBooking(Passenger passenger, Room room, Booking booking){

        passenger.setBooking(null);
        room.deleteBooking(booking);
        this.deleteBooking(booking);
    }
}
