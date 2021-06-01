package hotelServiceApp.backEndCode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelData {

    private List<Passenger> passengerList;
    private List<Room> roomList;
    private List<Booking> bookingList;
    private List<SupplyItem> supplyItemList;
    private List<Receptionist> recepcionistList;
    private Admin admin;

    public HotelData() {

        this.passengerList = new ArrayList<>();
        this.roomList = new ArrayList<>();
        this.bookingList = new ArrayList<>();
        this.supplyItemList = new ArrayList<>();
        this.recepcionistList = new ArrayList<>();
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

    public List<SupplyItem> getSupplyItemList() {

        return supplyItemList;
    }

    public void setSupplyItemList(SupplyItem supplyItem) {

        this.supplyItemList.add(supplyItem);
    }

    public List<Receptionist> getRecepcionistList() {

        return recepcionistList;
    }

    public void setRecepcionistList(Receptionist recepcionist) {

        this.recepcionistList.add(recepcionist);
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

    /**
     * public Room searchAvailableRoom(LocalDate firstDate, LocalDate secondDate, int amountOfRooms)
     * This method confirms if there is an available room within the two localDates in parameters and with the amount of rooms specified.
     */
    public Room searchAvailableRoom(LocalDate firstDate, LocalDate secondDate, int amountOfRooms) {

        Room roomFound = null;
        for (Room room : this.roomList) {

            if (room.getBedroomsAmount().equals(amountOfRooms) && room.isRoomAvailable(firstDate, secondDate).equals(true)) {

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
        for (Receptionist r : this.recepcionistList) {

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
        for (Receptionist r : this.recepcionistList) {

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
        for (Receptionist r : this.recepcionistList) {

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
        for (Receptionist r : this.recepcionistList) {

            if (r.getUsername().equals(username)) {

                receptionist = r;
            }
        }
        return receptionist;
    }

    /*public void hotelDataSaver(HotelData hotel){

        Gson gson = new Gson();
        String json = gson.toJson(hotel);

        try {
            FileWriter writer = new FileWriter("HotelData.json");
            writer.write(json);
            writer.close();
        }
        catch (FileAlreadyExistsException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void importDataFromFile(){
        Type PASSENGER_TYPE = new TypeToken<List<Passenger>>(){}.getType();
        Type ROOM_TYPE = new TypeToken<List<Room>>(){}.getType();
        Type BOOKING_TYPE = new TypeToken<List<Booking>>(){}.getType();
        Type SUPPLYITEM_TYPE = new TypeToken<List<SupplyItem>>(){}.getType();
        Type RECEPTIONIST_TYPE = new TypeToken<List<Receptionist>>(){}.getType();

        Gson gson = new Gson();

        try{
            JsonReader reader = new JsonReader(new FileReader("HotelData.json"));
            this.passengerList = gson.fromJson(reader, PASSENGER_TYPE);
            this.roomList = gson.fromJson(reader, ROOM_TYPE);
            this.bookingList = gson.fromJson(reader, BOOKING_TYPE);
            this.supplyItemList = gson.fromJson(reader, SUPPLYITEM_TYPE);
            this.recepcionistList = gson.fromJson(reader, RECEPTIONIST_TYPE);
            this.admin = gson.fromJson(reader, Admin.class);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }*/
}
