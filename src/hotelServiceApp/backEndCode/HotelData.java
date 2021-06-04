package hotelServiceApp.backEndCode;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelData {

    private List<Passenger> passengerList;
    private List<Room> roomList;
    private List<Booking> bookingList;
    private List<SupplyItem> supplyItemList;
    private List<Receptionist> receptionistList;
    private Admin admin;

    public HotelData() {

        this.passengerList = new ArrayList<>();
        this.roomList = new ArrayList<>();
        this.bookingList = new ArrayList<>();
        this.supplyItemList = new ArrayList<>();
        this.receptionistList = new ArrayList<>();
    }

    public List<Passenger> getPassengerList() {

        return passengerList;
    }

    public void setPassengerList(Passenger passenger) {

        this.passengerList.add(passenger);
    }

    public void setPassengerEntireList(List<Passenger> passengerList){

        this.passengerList = passengerList;
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

    public void setRoomEntireList(List<Room> roomList){

        this.roomList = roomList;
    }

    public List<Booking> getBookingList() {

        return bookingList;
    }

    public void setBookingList(Booking booking) {

        this.bookingList.add(booking);
    }

    public void setBookingEntireList(List<Booking> bookingList){

        this.bookingList = bookingList;
    }

    public List<SupplyItem> getSupplyItemList() {

        return supplyItemList;
    }

    public void setSupplyItemList(SupplyItem supplyItem) {

        this.supplyItemList.add(supplyItem);
    }


    public List<Receptionist> getReceptionistList() {

        return receptionistList;
    }

    public void setReceptionistList(Receptionist recepcionist) {

        this.receptionistList.add(recepcionist);

    public void setSupplyItemEntireList(List<SupplyItem> supplyItemList){

        this.supplyItemList = supplyItemList;
    }

    public List<Receptionist> getReceptionistList() {

        return receptionistList;
    }

    public void setReceptionistList(Receptionist recepcionist) {

        this.receptionistList.add(recepcionist);
    }

    public void setReceptionistEntireList(List<Receptionist> receptionistList){

        this.receptionistList = receptionistList;

    }

    public Admin getAdmin() {

        return admin;
    }

    public void setAdmin(Admin admin) {

        this.admin = admin;
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
     * public Passenger dniSearchPassenger(String dni)
     * This method searches in the PassengerList of the HotelData nad returns the passenger.
     * We assume that the passenger already exists. It needs to be checked first using the method passengerExists
     */
    public Passenger dniSearchPassenger(String dni) {

        Passenger passenger = null;
        for (Passenger p : this.passengerList) {

            if (p.getDni().equals(dni)) {

                passenger = p;
            }
        }
        return passenger;
    }

    /**
     * public Passenger usernameSearchPassenger(String username)
     * This method searches in the PassengerList of the HotelData and returns the passenger.
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

    /**
     * public Room searchAvailableRoom(LocalDate firstDate, LocalDate secondDate, int amountOfRooms)
     * This method confirms if there is an available room within the two localDates in parameters and with the amount of rooms specified.
     */
    public Room searchAvailableRoom(LocalDate firstDate, LocalDate secondDate, int amountOfRooms, int amountOfPassengers) {

        Room roomFound = null;
        for (Room room : this.roomList) {

            if (room.getBedroomsAmount().equals(amountOfRooms) && room.isRoomAvailable(firstDate, secondDate).equals(true) && amountOfPassengers <= room.getMaxCapacity()) {

                roomFound = room;
            }
        }
        return roomFound;
    }

    /**
     * public void setNewBooking(Passenger passenger, Room room, Booking booking)
     * This method sets a new booking into the specific room, into the bookingList and into the passenger.
     */
    public void setNewBooking(Passenger passenger, Room room, Booking booking) {

        passenger.setBooking(booking);
        room.setBookingList(booking);
        this.setBookingList(booking);
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
     * public void deleteExistingBooking(Passenger passenger, Room room, Booking booking)
     * This method deletes an existing book from the passenger, this list and from the room.
     */
    public void deleteExistingBooking(Passenger passenger, Room room, Booking booking) {

        passenger.setBooking(null);
        room.deleteBooking(booking);
        this.deleteBooking(booking);
    }

    /**
     * public ObservableList<SupplyItem> getItemsInStock(SupplySections section)
     * This method searches into the hotel list if there is stock of the items with the section passed by parameter.
     * It add the items into an observable list to return it and be used in a ListView
     */
    public ObservableList<SupplyItem> getItemsInStock(SupplySections section) {

        List<SupplyItem> items = new ArrayList<>();

        for (SupplyItem item : this.supplyItemList) {

            if (item.getSection().equals(section) && item.getStock() > 0) {

                items.add(item);
            }
        }
        ObservableList<SupplyItem> itemsInStock = FXCollections.observableList(items);
        return itemsInStock;
    }

    /**
     * public void setNewPurchase(Passenger passenger, Purchase purchase)
     * This method adds a new purchase to the passenger in the parameter.
     */
    public void setNewPurchase(Passenger passenger, Purchase purchase) {

        passenger.setPurchases(purchase);
    }

    /**
     * public Boolean receptionistExists(String dni)
     * This method searches in the receptionistList of the HotelData if the dni in the parameter is already saved on a existing receptionist.
     */
    public Boolean receptionistExists(String dni) {

        Boolean confirm = false;
        for (Receptionist r : this.receptionistList) {

            if (r.getDni().equals(dni)) {

                confirm = true;
            }
        }
        return confirm;
    }

    /**
     * public Receptionist receptionistDniExists(String dni)
     * This method searches in the ReceptionistList of the HotelData and return the receptionist.
     * We assume that the receptionist already exists. It needs to be checked first using the method receptionistExists.
     */
    public Receptionist receptionistDniExists(String dni) {

        Receptionist receptionist = null;
        for (Receptionist r : this.receptionistList) {

            if (r.getDni().equals(dni)) {

                receptionist = r;
            }
        }
        return receptionist;
    }

    /**
     * public Boolean receptionistUsernameExists(String username)
     * This method searches in the receptionistList of the HotelData if the username is already taken.
     */
    public Boolean receptionistUsernameExists(String username) {

        Boolean confirm = false;
        for (Receptionist r : this.receptionistList) {

            if (r.getUsername().equals(username)) {

                confirm = true;
            }
        }
        return confirm;
    }

    /**
     * public Receptionist usernameSearchReceptionist(String username)
     * This method searches in the PassengerList of the HotelData and return the passenger.
     * We assume that the passenger already exists. It needs to be checked first using the method passengerExists.
     */
    public Receptionist usernameSearchReceptionist(String username) {

        Receptionist receptionist = null;
        for (Receptionist r : this.receptionistList) {

            if (r.getUsername().equals(username)) {

                receptionist = r;
            }
        }
        return receptionist;
    }

    /**
     * public void setCheckIn(Passenger passenger, Occupation occupation, List<Passenger> passengerList)
     * This method sets a check in setting the Occupation, Passengers list and state of the room into the respective room.
     * It also sets every Passenger state hosted to true and sets their room.
     * It also sets the amount of money into the admin account.
     */
    public void setCheckIn(Passenger passenger, Occupation occupation, List<Passenger> passengerList) {

        passenger.getBooking().getRoom().setPassengers(passengerList);
        passenger.getBooking().getRoom().setOccupation(occupation);
        passenger.getBooking().getRoom().setAvailable(false);
        for (Passenger p : passengerList) {
            p.setHosted(true);
            p.setRoom(occupation.getBooking().getRoom());
        }
        this.admin.setHotelTotalCash(admin.getHotelTotalCash() + occupation.getOccupationPrice());
    }

    /**
     * public void setCheckOut(Passenger passenger, double total)
     * This method sets a check out setting every passenger his hosted state to false, room to null and booking to null.
     * It also sets the room Occupation to null and sets the available state to true.
     * It also sets the amount of money of all the purchases from all the passengers into the admin account.
     */
    public void setCheckOut(Passenger passenger, double total) {

        List<Passenger> passengers = passenger.getRoom().getPassengers();
        Room room = passenger.getRoom();
        for (Passenger p : passengers) {

            p.setHosted(false);
            p.setRoom(null);
            p.setBooking(null);
        }
        room.setOccupation(null);
        room.setAvailable(true);
        room.getPassengers().removeAll(passengers);
        this.admin.setHotelTotalCash(this.admin.getHotelTotalCash() + total);
    }

    /**
     * public Room searchRoomNumber(int roomNumber)
     * This method searches for a room in the roomList into the HotelData.
     * This returns the room if it was found or null if not.
     */
    public Room searchRoomNumber(int roomNumber) {

        Room roomFound = null;
        for (Room room : this.roomList) {

            if (room.getRoomNumber().equals(roomNumber)) {

                roomFound = room;
            }
        }
        return roomFound;
    }

    /**
     * public ObservableList<Room> returnAllTheRooms()
     * This method copy all the rooms into an observable list used on a list view then.
     */
    public ObservableList<Room> returnAllTheRooms() {

        List<Room> list = new ArrayList<>();

        for (Room r : this.roomList) {

            list.add(r);
        }

        ObservableList<Room> observableList = FXCollections.observableList(list);
        return observableList;
    }

    /**
     * public ObservableList<SupplyItem> returnAllSectionItems(SupplySections section)
     * This method searches for all the items into the supplyItemsList into HotelData with the section in parameter.
     * It returns an observable list used on a List view then.
     */
    public ObservableList<SupplyItem> returnAllSectionItems(SupplySections section) {

        List<SupplyItem> list = new ArrayList<>();

        for (SupplyItem i : this.supplyItemList) {

            if (i.getSection().equals(section)) {

                list.add(i);
            }
        }
        ObservableList<SupplyItem> observableList = FXCollections.observableList(list);
        return observableList;
    }
}
